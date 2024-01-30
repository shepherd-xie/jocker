package com.github.shepherdxie.jocker;

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

    public Object info() {
        DockerCommand dockerCommand = new DockerCommand();
        dockerCommand.setDockerConfig(dockerConfig);
        dockerCommand.setCommand("info");

        return commandExecutor.execute(dockerCommand);
    }

}
