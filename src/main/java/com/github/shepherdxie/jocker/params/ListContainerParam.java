package com.github.shepherdxie.jocker.params;

import lombok.Data;

import java.util.Map;

/**
 * Represents parameters for listing containers in Docker.
 */
@Data
public class ListContainerParam {
    /**
     * Flag indicating whether to return all containers.
     * By default, only running containers are shown.
     */
    private boolean all;

    /**
     * Return this number of most recently created containers, including non-running ones.
     */
    private Integer limit;

    /**
     * Flag indicating whether to return the size of containers.
     */
    private boolean size;

    /**
     * Filters to process on the container list.
     * Encoded as JSON (a map[string][]string).
     * For example, {"status": ["paused"]} will only return paused containers.
     * <p>
     * Available filters:
     * <ul>
     *     <li>{@code ancestor=(<image-name>[:<tag>], <image id>, or <image@digest>)}</li>
     *     <li>{@code before=(<container id> or <container name>)}</li>
     *     <li>{@code expose=(<port>[/<proto>]|<startport-endport>/[<proto>])}</li>
     *     <li>{@code exited=<int> containers with exit code of <int>}</li>
     *     <li>{@code health=(starting|healthy|unhealthy|none)}</li>
     *     <li>{@code id=<ID> a container's ID}</li>
     *     <li>{@code isolation=(default|process|hyperv) (Windows daemon only)}</li>
     *     <li>{@code is-task=(true|false)}</li>
     *     <li>{@code label=key or label="key=value" of a container label}</li>
     *     <li>{@code name=<name> a container's name}</li>
     *     <li>{@code network=(<network id> or <network name>)}</li>
     *     <li>{@code publish=(<port>[/<proto>]|<startport-endport>/[<proto>])}</li>
     *     <li>{@code since=(<container id> or <container name>)}</li>
     *     <li>{@code status=(created|restarting|running|removing|paused|exited|dead)}</li>
     *     <li>{@code volume=(<volume name> or <mount point destination>)}</li>
     * </ul>
     * </p>
     */
    private Map<String, String[]> filters;
}
