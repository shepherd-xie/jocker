package com.github.shepherdxie.jocker;

import com.github.shepherdxie.jocker.executor.CommandExecutor;

/**
 * @author Shepherd Xie
 * @since 2024/1/29
 */
public class Docker {

    private final CommandExecutor commandExecutor;
    private final DockerConfig dockerConfig;

    public Docker(CommandExecutor commandExecutor, DockerConfig dockerConfig) {
        this.commandExecutor = commandExecutor;
        this.dockerConfig = dockerConfig;
    }

    public DockerInfo info() {
        DockerCommand dockerCommand = new DockerCommand();
        dockerCommand.setDockerConfig(dockerConfig);
        dockerCommand.setCommand("info");

        return commandExecutor.execute(dockerCommand, DockerInfo.class);
    }

}
