package com.github.shepherdxie.jocker;

import lombok.Data;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * @author Shepherd Xie
 * @since 2024/1/30
 */
@Data
public class DockerConfig {
    private String ip;
    private int port;

    public DockerConfig(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public static DockerConfig of(String ip, int port) {
        return new DockerConfig(ip, port);
    }

    public URL getHttpUrl() {
        try {
            URL url = new URL("https://" + ip + ":" + port);
            return url;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
