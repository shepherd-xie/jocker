package com.github.shepherdxie.jocker.executor;

/**
 * @author Shepherd Xie
 * @since 2024/1/30
 */
public interface DockerExecutor {

    ExecutorResponse execute(ExecutorRequest request);

}
