package com.github.shepherdxie.jocker.executor;

import lombok.Data;

/**
 * @author Shepherd Xie
 * @since 2024/4/18
 */
@Data
public class ExecutorRequest {
    private String command;

    public ExecutorRequest(String command) {
        this.command = command;
    }
}
