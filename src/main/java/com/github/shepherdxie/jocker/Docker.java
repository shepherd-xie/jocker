package com.github.shepherdxie.jocker;


/**
 * @author Shepherd Xie
 * @since 2024/1/30
 */
public class Docker {

    public static DockerContext context() {
        return context(Environment.DEFAULT);
    }
    public static DockerContext context(Environment environment) {
        return new DockerContext(environment);
    }

}
