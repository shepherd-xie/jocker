package com.github.shepherdxie;

import com.github.shepherdxie.jocker.entity.DockerInfo;
import com.github.shepherdxie.jocker.executor.HttpsClientDockerExecutor;
import com.github.shepherdxie.utils.FileUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // 客户端证书和私钥文件路径
        String clientCertPath = FileUtil.getSecurity("/ca/cert.pem");
        String clientKeyPath = FileUtil.getSecurity("/ca/key.pem");

        // CA 证书文件路径
        String caCertPath = FileUtil.getSecurity("/ca/ca.pem");

        HttpsClientDockerExecutor dockerExecutor = new HttpsClientDockerExecutor(clientCertPath, clientKeyPath, caCertPath);
        System.out.println(dockerExecutor.exec(DockerInfo.class));
    }
}