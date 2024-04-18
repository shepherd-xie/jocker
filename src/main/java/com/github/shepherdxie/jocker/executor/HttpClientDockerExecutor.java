package com.github.shepherdxie.jocker.executor;

import com.github.shepherdxie.jocker.Environment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

/**
 * @author Shepherd Xie
 * @since 2024/1/30
 */
public class HttpClientDockerExecutor extends AbstractDockerExecutor {
    public HttpClientDockerExecutor(Environment environment) {
        super(environment);
    }

    @Override
    public ExecutorResponse execute(ExecutorRequest request) {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(environment.getProtocol() + environment.getHost()).openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            connection.setRequestMethod("GET");
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        }

        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            connection.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
