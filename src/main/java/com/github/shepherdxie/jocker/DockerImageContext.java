package com.github.shepherdxie.jocker;

import com.github.shepherdxie.jocker.entity.ContainerConfig;
import com.github.shepherdxie.jocker.entity.ContainerSummary;
import com.github.shepherdxie.jocker.entity.ImageSummary;
import com.github.shepherdxie.jocker.executor.DockerExecutor;
import com.github.shepherdxie.jocker.executor.ExecutorRequest;
import com.github.shepherdxie.jocker.executor.ExecutorResponse;
import com.github.shepherdxie.jocker.params.ContainerParams;
import com.github.shepherdxie.jocker.params.ImageListQueryParams;

import java.util.List;

/**
 * @author Shepherd Xie
 * @since 2024/4/17
 */
public class DockerImageContext {
    private final DockerExecutor dockerExecutor;
    public DockerImageContext(DockerExecutor dockerExecutor) {
        this.dockerExecutor = dockerExecutor;
    }

    public static DockerImageContext superContext(DockerContext dockerContext) {
        return null;
    }

    public List<ImageSummary> list(ImageListQueryParams params) {
        // 在远程服务器上执行命令
        ExecutorRequest request = new ExecutorRequest(ExecutorRequest.Method.GET, "/images/json", params);
        ExecutorResponse response = dockerExecutor.execute(request);
        return ResponseReader.readList(response.getRaw(), ImageSummary.class);
    }

    public ContainerSummary create(ContainerParams containerParams, ContainerConfig containerConfig) {
        ExecutorRequest request = new ExecutorRequest(ExecutorRequest.Method.POST, "/containers/create", containerParams, containerConfig);
        ExecutorResponse response = dockerExecutor.execute(request);
        if (response.getExitCode() != 0) {
            throw new RuntimeException(response.getRaw());
        }
        return ResponseReader.readValue(response.getRaw(), ContainerSummary.class);
    }
}
