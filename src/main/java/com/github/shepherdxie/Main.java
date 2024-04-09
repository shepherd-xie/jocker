package com.github.shepherdxie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.shepherdxie.utils.FileUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Docker 守护进程的主机地址和端口
        String dockerHost = "https://127.0.0.1:8080";

        // 客户端证书和私钥文件路径
        String clientCertPath = FileUtil.getResource("security/ca/cert.pem");
        String clientKeyPath = FileUtil.getResource("security/ca/key.pem");

        // CA 证书文件路径
        String caCertPath = FileUtil.getResource("security/ca/ca.pem");

        // 创建 OkHttpClient 对象
        OkHttpClient client = new OkHttpClient.Builder()
                .sslSocketFactory(
                        Objects.requireNonNull(HttpsUtils.getSslSocketFactory(clientCertPath, clientKeyPath, caCertPath)),
                        HttpsUtils.getTrustManager())
                .build();

        // 构建请求
        Request request = new Request.Builder()
                .url(dockerHost + "/info")
                .build();

        // 发送请求并获取响应
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                Map map = objectMapper.readValue(response.body().string(), Map.class);
                map.entrySet().forEach(System.out::println);
//                System.out.println(response.body().string());
            } else {
                System.out.println("Request failed: " + response);
            }
        }
    }
}