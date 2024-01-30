package com.github.shepherdxie;

import com.github.shepherdxie.jocker.CommandExecutor;
import com.github.shepherdxie.jocker.Docker;
import com.github.shepherdxie.jocker.DockerConfig;
import com.github.shepherdxie.jocker.HttpClientCommandExecutor;

/**
 * @author Shepherd Xie
 * @since 2024/1/24
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String ip = "39.100.160.41";
        DockerConfig dockerConfig = DockerConfig.of(ip, 2375);

        CommandExecutor commandExecutor = new HttpClientCommandExecutor();
        Docker docker = new Docker(commandExecutor, dockerConfig);

        System.out.println(docker.info());
    }
}