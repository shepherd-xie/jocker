package com.github.shepherdxie.jocker;

/**
 * @author Shepherd Xie
 * @since 2024/1/30
 */
public interface CommandExecutor {

    Object execute(DockerCommand dockerCommand);

}
