package com.github.shepherdxie.jocker;

import com.github.shepherdxie.jocker.executor.DockerExecutor;
import com.github.shepherdxie.jocker.executor.DockerExecutorFactory;

/**
 * @author Shepherd Xie
 * @since 2024/4/17
 */
public class DockerContext {
    private final DockerExecutor dockerExecutor;
    private final DockerContainerContext container;

    public DockerContext(Environment environment) {
        dockerExecutor = DockerExecutorFactory.executor(environment);
        container = new DockerContainerContext(dockerExecutor);
    }


    public DockerContainerContext container() {
        return container;
    }

    public void image() {

    }

    public void network() {

    }

    public void volume() {

    }

    public void exec() {

    }
}
