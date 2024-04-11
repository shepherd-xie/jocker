package com.github.shepherdxie.jocker.executor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.shepherdxie.jocker.DockerCommand;

import java.io.IOException;

/**
 * @author Shepherd Xie
 * @since 2024/1/30
 */
public interface DockerExecutor {

    ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    String execute(DockerCommand dockerCommand);

    default <T> T execute(DockerCommand dockerCommand, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(execute(dockerCommand).toString(), clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
