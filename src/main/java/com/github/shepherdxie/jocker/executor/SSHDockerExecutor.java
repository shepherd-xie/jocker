package com.github.shepherdxie.jocker.executor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.shepherdxie.jocker.Environment;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;

/**
 * @author Shepherd Xie
 * @since 2024/2/7
 */
@Slf4j
public class SSHDockerExecutor extends AbstractDockerExecutor {
    private Session session;

    public SSHDockerExecutor(Environment environment) {
        super(environment);
        this.session = environment.getSession();
    }

    private String getCommand(ExecutorRequest request) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        StringBuilder sb = new StringBuilder();
        if (request.getMethod() != ExecutorRequest.Method.GET) {
            sb.append(" -H \"Content-Type: application/json\" ");
            String method = " -X " + request.getMethod();
            sb.append(method);
            try {
                String body = " -d '" + objectMapper.writeValueAsString(request.getBody()) + "'";
                sb.append(body);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(request.getParams());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        String params = jsonString.replaceAll("[\"{}]", "").replaceAll(",", "&").replaceAll(":", "=");

        String command = "curl --unix-socket {0} \"http://localhost/v1.44{1}{2}\" {3}";

        String format = MessageFormat.format(command, environment.getHost(), request.getPath(), params.isBlank() ? "" : "?" + params, sb.toString());
        request.setCommand(format);
        log.info(format);
        return format;
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
        channel.setCommand(getCommand(request));

        try (InputStream in = channel.getInputStream()) {
            channel.connect();

            response.setExitCode(channel.getExitStatus());

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
