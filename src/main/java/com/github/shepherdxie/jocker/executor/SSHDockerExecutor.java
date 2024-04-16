package com.github.shepherdxie.jocker.executor;

import com.github.shepherdxie.Configuration;
import com.github.shepherdxie.jocker.DockerCommand;
import com.github.shepherdxie.jocker.DockerConfig;
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
public class SSHDockerExecutor implements DockerExecutor {

    @Override
    public String execute(DockerCommand dockerCommand) {

        return null;
    }


    public static void main(String[] args) throws JSchException {
        SSHSessionFactory sshSessionFactory = new SSHSessionFactory();
        Session session = sshSessionFactory.withPrivateKey(
                DockerConfig.INSTANCE.getIp(),
                Configuration.get("docker.ssh.username"),
                Integer.parseInt(Configuration.get("docker.ssh.port")),
                Configuration.get("docker.ssh.privateKey")
        );
        session.connect();
        // 在远程服务器上执行命令
        String command = "curl --unix-socket /var/run/docker.sock http://localhost/_ping";
        ChannelExec channel = (ChannelExec) session.openChannel("exec");
        channel.setCommand(command);

        try (InputStream in = channel.getInputStream()) {

            channel.connect();

            // 读取命令执行的输出
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            System.out.println(stringBuilder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭连接
            channel.disconnect();
            session.disconnect();
        }
    }

}
