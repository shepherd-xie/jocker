package com.github.shepherdxie.jocker.executor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.shepherdxie.jocker.DockerCommand;
import com.github.shepherdxie.utils.FileUtil;
import com.github.shepherdxie.utils.HttpsUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Objects;

/**
 * @author Shepherd Xie
 * @since 2024/4/11
 */
public class HttpsClientDockerExecutor implements DockerExecutor {

    private final SSLSocketFactory sslSocketFactory;
    private final X509TrustManager x509TrustManager;

    public HttpsClientDockerExecutor(String clientCertPath, String clientKeyPath, String caCertPath) throws IOException {
        this.sslSocketFactory = HttpsUtils.getSslSocketFactory(clientCertPath, clientKeyPath, caCertPath);
        this.x509TrustManager = HttpsUtils.getTrustManager();
    }

    public HttpsClientDockerExecutor(SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) {
        this.sslSocketFactory = sslSocketFactory;
        this.x509TrustManager = x509TrustManager;
    }

    @Override
    public String execute(DockerCommand dockerCommand) {
        return null;
    }

    public <T> T exec(Class<T> valueType) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Docker 守护进程的主机地址和端口
        String dockerHost = MessageFormat.format(
                "https://{0}:{1}",
                FileUtil.getSecurityConfig("docker.host"),
                FileUtil.getSecurityConfig("docker.port")
        );

        // 创建 OkHttpClient 对象
        OkHttpClient client = new OkHttpClient.Builder()
                .sslSocketFactory(Objects.requireNonNull(sslSocketFactory), x509TrustManager)
                .build();

        // 构建请求
        Request request = new Request.Builder()
                .url(dockerHost + "/v1.44/info")
                .build();

        // 发送请求并获取响应
        try (Response response = client.newCall(request).execute()) {
            return ResponseReader.readValue(response, valueType);
        }
    }

}
