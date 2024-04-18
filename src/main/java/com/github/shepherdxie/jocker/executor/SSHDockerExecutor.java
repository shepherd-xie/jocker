package com.github.shepherdxie.jocker.executor;

import com.github.shepherdxie.jocker.Environment;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Shepherd Xie
 * @since 2024/2/7
 */
public class SSHDockerExecutor extends AbstractDockerExecutor {
    private Session session;

    public SSHDockerExecutor(Environment environment) {
        super(environment);
        this.session = environment.getSession();
    }


    @Override
    public ExecutorResponse execute(ExecutorRequest request) {
        ExecutorResponse response = new ExecutorResponse();
        response.setRequest(request);

        try {
            session.connect();
        } catch (JSchException e) {
            throw new RuntimeException(e);
        }

        ChannelExec channel = null;
        try {
            channel = (ChannelExec) session.openChannel("exec");
        } catch (JSchException e) {
            throw new RuntimeException(e);
        }
        channel.setCommand(request.getCommand());

        try (InputStream in = channel.getInputStream()) {
            channel.connect();

            // 读取命令执行的输出
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            response.setRaw(stringBuilder.toString());
        } catch (IOException | JSchException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭连接
            channel.disconnect();
            session.disconnect();
        }
        return response;
    }
}
