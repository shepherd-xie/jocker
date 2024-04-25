package com.github.shepherdxie;

import com.github.shepherdxie.jocker.Docker;
import com.github.shepherdxie.jocker.DockerConfig;
import com.github.shepherdxie.jocker.DockerContext;
import com.github.shepherdxie.jocker.Environment;
import com.github.shepherdxie.jocker.entity.ContainerSummary;
import com.github.shepherdxie.jocker.executor.SSHSessionFactory;
import com.github.shepherdxie.utils.FileUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // 客户端证书和私钥文件路径
        String clientCertPath = FileUtil.getSecurity("/ca/cert.pem");
        String clientKeyPath = FileUtil.getSecurity("/ca/key.pem");

        // CA 证书文件路径
        String caCertPath = FileUtil.getSecurity("/ca/ca.pem");

        Environment environment = Environment.builder()
                .protocol(Environment.Protocol.UNIX_SOCKET_VIA_SSH)
                .host("/var/run/docker.sock")
                .viaSsh(SSHSessionFactory.withPrivateKey(
                        DockerConfig.INSTANCE.getIp(),
                        Configuration.get("docker.ssh.username"),
                        Integer.parseInt(Configuration.get("docker.ssh.port")),
                        Configuration.get("docker.ssh.privateKey")
                ))
                .build();

        DockerContext context = Docker.context(environment);
        for (ContainerSummary container : context.container().json()) {
            System.out.println(container);
        }
    }
}