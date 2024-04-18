package com.github.shepherdxie.jocker;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.shepherdxie.jocker.entity.ContainerSummary;
import com.github.shepherdxie.jocker.executor.DockerExecutor;
import com.github.shepherdxie.jocker.executor.ExecutorRequest;
import com.github.shepherdxie.jocker.executor.ExecutorResponse;

import java.util.List;

/**
 * @author Shepherd Xie
 * @since 2024/4/17
 */
public class DockerContainerContext {
    private final DockerExecutor dockerExecutor;
    public DockerContainerContext(DockerExecutor dockerExecutor) {
        this.dockerExecutor = dockerExecutor;
    }

    public static DockerContainerContext superContext(DockerContext dockerContext) {
        return null;
    }

    public List<ContainerSummary> ls() {
        // 在远程服务器上执行命令
        String command = "curl --unix-socket /var/run/docker.sock http://localhost/v1.44/containers/json\\?all=true";

        ExecutorRequest request = new ExecutorRequest(command);
        ExecutorResponse response = dockerExecutor.execute(request);
        return ResponseReader.readList(response.getRaw(), ContainerSummary.class);
    }
}
