package com.github.shepherdxie.jocker.executor;

import java.io.InputStream;
import java.util.Map;

/**
 * @author Shepherd Xie
 * @since 2024/4/18
 */
public record ExecutorRequest(
        Method method,
        String path,
        Object params,
        Object body,
        InputStream inputStream
) {
    public ExecutorRequest(Method method, String path) {
        this(method, path, null, null, null);
    }

    public ExecutorRequest(Method method, String path, Object params) {
        this(method, path, params, null, null);
    }

    public enum Method {
        GET, POST, PATCH, DELETE, PUT, HEAD, OPTIONS
    }
}
