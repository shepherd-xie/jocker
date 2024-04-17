package com.github.shepherdxie.jocker.executor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.shepherdxie.jocker.*;
import com.github.shepherdxie.jocker.entity.DockerInfo;
import com.github.shepherdxie.jocker.entity.InfoOptions;

/**
 * @author Shepherd Xie
 * @since 2024/1/29
 */
public class DockerClient implements Docker {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final DockerExecutor dockerExecutor;
    private final DockerConfig dockerConfig;

    public DockerClient(DockerExecutor dockerExecutor, DockerConfig dockerConfig) {
        this.dockerExecutor = dockerExecutor;
        this.dockerConfig = dockerConfig;
    }

    public DockerInfo info() {
        DockerCommand dockerCommand = new DockerCommand();
        dockerCommand.setDockerConfig(dockerConfig);
        dockerCommand.setCommand("info");

        return dockerExecutor.execute(dockerCommand, DockerInfo.class);
    }

    public DockerInfo info(InfoOptions infoOptions) {
        DockerCommand dockerCommand = new DockerCommand();
        dockerCommand.setDockerConfig(dockerConfig);
        dockerCommand.setCommand("info");

        String jsonResult = dockerExecutor.execute(dockerCommand);
        OBJECT_MAPPER.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        try {
            DockerInfo dockerInfo = OBJECT_MAPPER.readValue(jsonResult, DockerInfo.class);
            return dockerInfo;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
