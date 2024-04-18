package com.github.shepherdxie.jocker.executor;

import lombok.Data;

/**
 * @author Shepherd Xie
 * @since 2024/4/18
 */
@Data
public class ExecutorResponse {
    private ExecutorRequest request;
    private String raw;
}
