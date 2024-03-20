package com.github.shepherdxie;

/**
 * @author Shepherd Xie
 * @since 2024/3/20
 */

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.net.ssl.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import java.util.List;

public class OkHttpExample {
    public static void main(String[] args) throws Exception {
        // 设置主机名和端口号
        String host = "39.100.160.41";
        int port = 2376;

        // 加载 CA 证书
        X509Certificate caCert = loadCertificate("src/main/resources/security/ca/ca.pem");

        // 加载客户端证书和私钥
        X509Certificate clientCert = loadCertificate("src/main/resources/security/ca/cert.pem");
        PrivateKey clientKey = loadPrivateKey("src/main/resources/security/ca/key.pem");

        // 创建 OkHttpClient 实例
        OkHttpClient client = new OkHttpClient.Builder()
                .sslSocketFactory(getSSLContext(caCert, clientCert, clientKey).getSocketFactory(), getX509TrustManager())
                .hostnameVerifier((hostname, session) -> true)
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

    private static X509TrustManager getX509TrustManager() {
        try {
            TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            factory.init((KeyStore) null);
            TrustManager[] trustManagers = factory.getTrustManagers();
            return (X509TrustManager) trustManagers[0];
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 加载证书文件
    private static X509Certificate loadCertificate(String certPath) throws Exception {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        FileInputStream certFileInputStream = new FileInputStream(new File(certPath));
        return (X509Certificate) certificateFactory.generateCertificate(certFileInputStream);
    }

    // 加载私钥文件
    private static PrivateKey loadPrivateKey(String keyPath) throws Exception {
        FileInputStream keyFileInputStream = new FileInputStream(new File(keyPath));
        byte[] keyBytes = new byte[keyFileInputStream.available()];
        keyFileInputStream.read(keyBytes);
        keyFileInputStream.close();
        return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(keyBytes));
    }

    // 创建自定义 SSLContext
    private static SSLContext getSSLContext(X509Certificate caCert, X509Certificate clientCert, PrivateKey clientKey) throws Exception {
        // 创建 TrustManager
        TrustManager[] trustManagers = { getTrustManager(caCert) };

        // 创建 KeyManager
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        keyStore.setCertificateEntry("caCert", caCert);
        keyStore.setCertificateEntry("clientCert", clientCert);
        keyStore.setKeyEntry("clientKey", clientKey, new char[]{}, new Certificate[]{clientCert});
        keyManagerFactory.init(keyStore, new char[]{});

        // 创建 SSLContext
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), trustManagers, new SecureRandom());
        return sslContext;
    }

    // 创建自定义 TrustManager
    private static X509TrustManager getTrustManager(X509Certificate caCert) {
        return new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
//                List<X509Certificate> trustedCerts = Arrays.asList(caCert);
//                for (X509Certificate cert : chain) {
//                    for (X509Certificate trustedCert : trustedCerts) {
//                        if (cert.equals(trustedCert)) {
//                            return;
//                        }
//                    }
//                }
//                throw new CertificateException("Server certificate not trusted");
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
    }
}
