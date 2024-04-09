package com.github.shepherdxie;

import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;

public class HttpsUtils {

    public static SSLSocketFactory getSslSocketFactory(String clientCertPath, String clientKeyPath, String caCertPath) throws IOException {
        try {
            // 加载客户端证书
            InputStream clientCertInputStream = new FileInputStream(clientCertPath);
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            X509Certificate clientCertificate = (X509Certificate) certificateFactory.generateCertificate(clientCertInputStream);

            // 加载客户端私钥
            InputStream clientKeyInputStream = new FileInputStream(clientKeyPath);
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            keyStore.setCertificateEntry("clientCert", clientCertificate);
            keyStore.load(null); // You don't need the KeyStore instance to be initialized with null
            keyStore.setKeyEntry("clientKey", getPrivateKey(clientKeyInputStream), new char[] {}, new java.security.cert.Certificate[] {clientCertificate});

            // 加载 CA 证书
            InputStream caCertInputStream = new FileInputStream(caCertPath);
            X509Certificate caCertificate = (X509Certificate) certificateFactory.generateCertificate(caCertInputStream);

            // 构建 SSL 上下文
            SSLContext sslContext = SSLContext.getInstance("TLS");
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, new char[] {});
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null);
            trustStore.setCertificateEntry("caCert", caCertificate);
            trustManagerFactory.init(trustStore);
            sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
            return sslContext.getSocketFactory();
        } catch (Exception e) {
            throw new IOException("Failed to create SSL socket factory", e);
        }
    }

    private static PrivateKey getPrivateKey(InputStream keyInputStream) throws IOException {
        try {
            byte[] keyBytes = new byte[keyInputStream.available()];
            keyInputStream.read(keyBytes);
            String keyString = new String(keyBytes);
            String privateKeyPEM = keyString
                    .replace("-----BEGIN PRIVATE KEY-----", "")
                    .replaceAll(System.lineSeparator(), "")
                    .replace("-----END PRIVATE KEY-----", "");
            byte[] decoded = java.util.Base64.getDecoder().decode(privateKeyPEM);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decoded));
        } catch (Exception e) {
            throw new IOException("Failed to read private key", e);
        }
    }

    public static X509TrustManager getTrustManager() throws IOException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && trustManagers[0] instanceof X509TrustManager) {
                return (X509TrustManager) trustManagers[0];
            } else {
                throw new IllegalStateException("Unexpected default trust managers:" + java.util.Arrays.toString(trustManagers));
            }
        } catch (NoSuchAlgorithmException | KeyStoreException e) {
            throw new IOException("Failed to create trust manager", e);
        }
    }
}
