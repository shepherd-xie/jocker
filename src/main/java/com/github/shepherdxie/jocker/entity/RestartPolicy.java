package com.github.shepherdxie.jocker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Represents the behavior to apply when the container exits.
 * The default is not to restart.
 * An ever increasing delay (double the previous delay, starting at 100ms) is
 * added before each restart to prevent flooding the server.
 */
@Data
public class RestartPolicy {
    /**
     * Empty string means not to restart
     * `no` Do not automatically restart
     * `always` Always restart
     * `unless-stopped` Restart always except when the user has manually stopped the container
     * `on-failure` Restart only when the container exit code is non-zero
     */
    @JsonProperty("Name")
    private String name;

    /**
     * If `on-failure` is used, the number of times to retry before giving up.
     */
    @JsonProperty("MaximumRetryCount")
    private int maximumRetryCount;
}
