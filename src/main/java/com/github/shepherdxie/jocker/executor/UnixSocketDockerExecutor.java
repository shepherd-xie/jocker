package com.github.shepherdxie.jocker.executor;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.IOException;

/**
 * @author Shepherd Xie
 * @since 2024/4/16
 */
public class UnixSocketDockerExecutor {

    public static void main(String[] args) {
        String dockerSocketUrl = "http://localhost/_ping";

        OkHttpClient client = new OkHttpClient.Builder()
                .socketFactory(new UnixDomainSocketFactory(new File("/var/run/docker.sock")))
                .build();

        Request request = new Request.Builder()
                .url(dockerSocketUrl)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                System.out.println("Docker daemon is running.");
            } else {
                System.out.println("Failed to ping Docker daemon.");
            }
        } catch (IOException e) {
            System.out.println("Failed to connect to Docker daemon.");
            e.printStackTrace();
        }
    }

}
