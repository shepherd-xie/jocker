package com.github.shepherdxie;

import com.github.shepherdxie.jocker.executor.DockerClient;
import com.github.shepherdxie.jocker.executor.CommandExecutor;
import com.github.shepherdxie.jocker.DockerConfig;
import com.github.shepherdxie.jocker.executor.HttpClientCommandExecutor;

/**
 * @author Shepherd Xie
 * @since 2024/1/24
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String ip = "39.100.160.41";
        DockerConfig dockerConfig = DockerConfig.of(ip, 2375);

        CommandExecutor commandExecutor = new HttpClientCommandExecutor();
        DockerClient dockerClient = new DockerClient(commandExecutor, dockerConfig);

        System.out.println(dockerClient.info());
    }
}