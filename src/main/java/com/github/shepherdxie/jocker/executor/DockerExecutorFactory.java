package com.github.shepherdxie.jocker.executor;

import com.github.shepherdxie.jocker.Environment;

/**
 * @author Shepherd Xie
 * @since 2024/4/18
 */
public class DockerExecutorFactory {

    private Environment environment;

    public static DockerExecutor executor(Environment environment) {
        return switch (environment.getProtocol()) {
            case UNIX_SOCKET -> new HttpClientDockerExecutor(environment);
            case UNIX_SOCKET_VIA_SSH -> new SSHDockerExecutor(environment);
            default -> throw new RuntimeException("Unsupported protocol: " + environment.getProtocol());
        };
    }

}
