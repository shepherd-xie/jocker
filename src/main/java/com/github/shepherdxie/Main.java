package com.github.shepherdxie;

import com.github.shepherdxie.jocker.Docker;
import com.github.shepherdxie.jocker.DockerConfig;
import com.github.shepherdxie.jocker.DockerContext;
import com.github.shepherdxie.jocker.Environment;
import com.github.shepherdxie.jocker.entity.ContainerConfig;
import com.github.shepherdxie.jocker.entity.ContainerSummary;
import com.github.shepherdxie.jocker.entity.ImageSummary;
import com.github.shepherdxie.jocker.executor.SSHSessionFactory;
import com.github.shepherdxie.jocker.params.ContainerListQueryParams;
import com.github.shepherdxie.jocker.params.ContainerParams;
import com.github.shepherdxie.jocker.params.ImageListQueryParams;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
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
//        ContainerListQueryParams containerListQueryParams = new ContainerListQueryParams();
//        containerListQueryParams.setAll(true);
//        ContainerConfig containerConfig = new ContainerConfig();
//        containerConfig.setImage("nginx");
//        ContainerParams containerParams = new ContainerParams();
//        containerParams.setName("test_nginx");
//        ContainerSummary containerSummary = context.container().create(containerParams, containerConfig);
//        System.out.println(containerSummary);
//        for (ContainerSummary container : context.container().list(containerListQueryParams)) {
//            System.out.println(container);
//        }
        ImageListQueryParams imageListQueryParams = new ImageListQueryParams();
        List<ImageSummary> imageSummaries = context.image().list(imageListQueryParams);
        for (ImageSummary imageSummary : imageSummaries) {
            System.out.println(imageSummary);
        }
    }
}