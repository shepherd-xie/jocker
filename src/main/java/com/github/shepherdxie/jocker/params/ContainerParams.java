package com.github.shepherdxie.jocker.params;

import lombok.Data;

/**
 * @author Shepherd Xie
 * @since 2024/5/10
 */
@Data
public class ContainerParams {
    /**
     * Assign the specified name to the container. Must match {@code /^\/?[a-zA-Z0-9][a-zA-Z0-9_.-]+$/}.
     */
    public String name;

    /**
     * Platform in the format {@code os[/arch[/variant]]} used for image lookup.
     *
     * <p>When specified, the daemon checks if the requested image is present
     * in the local image cache with the given OS and Architecture, and
     * otherwise returns a {@code 404} status.
     *
     * <p>If the option is not set, the host's native OS and Architecture are
     * used to look up the image in the image cache. However, if no platform
     * is passed and the given image does exist in the local image cache,
     * but its OS or architecture does not match, the container is created
     * with the available image, and a warning is added to the {@code Warnings}
     * field in the response, for example;
     * <pre>{@code
     *     WARNING: The requested image's platform (linux/arm64/v8) does not
     *              match the detected host platform (linux/amd64) and no
     *              specific platform was requested
     * }</pre>
     */
    public String platform = "";
}
