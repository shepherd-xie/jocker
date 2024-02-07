package com.github.shepherdxie.jocker.executor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.shepherdxie.jocker.*;

/**
 * @author Shepherd Xie
 * @since 2024/1/29
 */
public class DockerClient implements Docker {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final CommandExecutor commandExecutor;
    private final DockerConfig dockerConfig;

    public DockerClient(CommandExecutor commandExecutor, DockerConfig dockerConfig) {
        this.commandExecutor = commandExecutor;
        this.dockerConfig = dockerConfig;
    }

    public DockerInfo info() {
        DockerCommand dockerCommand = new DockerCommand();
        dockerCommand.setDockerConfig(dockerConfig);
        dockerCommand.setCommand("info");

        return commandExecutor.execute(dockerCommand, DockerInfo.class);
    }

    @Override
    public DockerInfo info(InfoOptions infoOptions) {
        DockerCommand dockerCommand = new DockerCommand();
        dockerCommand.setDockerConfig(dockerConfig);
        dockerCommand.setCommand("info");

        String jsonResult = commandExecutor.execute(dockerCommand);
        OBJECT_MAPPER.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        try {
            DockerInfo dockerInfo = OBJECT_MAPPER.readValue(jsonResult, DockerInfo.class);
            return dockerInfo;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
