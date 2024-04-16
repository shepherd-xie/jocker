package com.github.shepherdxie.jocker;

import com.github.shepherdxie.utils.FileUtil;
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
    public static final DockerConfig INSTANCE = new DockerConfig();

    private String ip;
    private int port;

    public DockerConfig() {
        this.ip = FileUtil.getSecurityConfig("docker.host");
        this.port = Integer.parseInt(FileUtil.getSecurityConfig("docker.port"));
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
