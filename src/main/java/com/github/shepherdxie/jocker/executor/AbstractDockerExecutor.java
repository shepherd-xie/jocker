package com.github.shepherdxie.jocker.executor;

import com.github.shepherdxie.jocker.Environment;

/**
 * @author Shepherd Xie
 * @since 2024/4/18
 */
public abstract class AbstractDockerExecutor implements DockerExecutor {
    protected Environment environment;

    public AbstractDockerExecutor(Environment environment) {
        this.environment = environment;
    }
}
