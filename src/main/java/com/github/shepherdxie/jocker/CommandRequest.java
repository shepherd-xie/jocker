package com.github.shepherdxie.jocker;

import lombok.Data;

import java.io.IOException;
import java.net.URL;

/**
 * @author Shepherd Xie
 * @since 2024/1/30
 */
@Data
public class CommandRequest {
    private DockerConfig dockerConfig;
    private String command;
    private Object options;

    public URL getHttpUrl() throws IOException {
        return new URL(dockerConfig.getHttpUrl() + "/" + command);
    }
}
