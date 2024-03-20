package com.github.shepherdxie;

import com.github.shepherdxie.jocker.DockerConfig;
import com.github.shepherdxie.jocker.executor.CommandExecutor;
import com.github.shepherdxie.jocker.executor.DockerClient;
import com.github.shepherdxie.jocker.executor.HttpClientCommandExecutor;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;

/**
 * @author Shepherd Xie
 * @since 2024/1/24
 */
public class Main {
    public static void main(String[] args) throws Exception {
//        DockerConfig dockerConfig = DockerConfig.of(Configuration.get("docker.host"), Configuration.get("docker.port", Integer.class));

//        CommandExecutor commandExecutor = new HttpClientCommandExecutor();
//        DockerClient dockerClient = new DockerClient(commandExecutor, dockerConfig);

//        System.out.println(dockerClient.info());
        main1(args);
    }

    public static void main1(String[] args) throws Exception {
        // 设置主机名和端口号
        String host = "39.100.160.41";
        int port = 2376;

        // 创建 OkHttpClient 实例
        OkHttpClient client = new OkHttpClient.Builder()
                .sslSocketFactory(getSSLContext().getSocketFactory(), getTrustManager())
                .build();

        // 设置请求
        Request request = new Request.Builder()
                .url("https://" + host + ":" + port + "/images/json")
                .build();

        // 发送请求
        try (Response response = client.newCall(request).execute()) {
            // 处理响应
            System.out.println("Response code: " + response.code());
            System.out.println("Response body: " + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 创建自定义 SSLContext
    private static SSLContext getSSLContext() throws Exception {
        // 加载客户端证书
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        FileInputStream certFileInputStream = new FileInputStream("src/main/resources/security/ca/cert.pem");
        Certificate certificate = certificateFactory.generateCertificate(certFileInputStream);

        // 加载客户端私钥
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        keyStore.setCertificateEntry("caCert", certificate);

        // 初始化 KeyManagerFactory
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, null);

        // 创建 SSLContext
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), null, new SecureRandom());
        return sslContext;
    }

    // 创建 TrustManager
    private static X509TrustManager getTrustManager() {
        return new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
    }
}