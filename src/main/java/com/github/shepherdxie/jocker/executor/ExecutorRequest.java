package com.github.shepherdxie.jocker.executor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;

/**
 * @author Shepherd Xie
 * @since 2024/4/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExecutorRequest {
    private Method method;
    private String path;
    private String command;
    private Object params;
    private Object body;
    private InputStream inputStream;

    public ExecutorRequest(Method method, String path, Object params) {
        this(method, path, params, null);
    }

    public ExecutorRequest(Method method, String path, Object params, Object body) {
        this.method = method;
        this.path = path;
        this.params = params;
        this.body = body;
    }

    public enum Method {
        GET, POST, PATCH, DELETE, PUT, HEAD, OPTIONS
    }
}
