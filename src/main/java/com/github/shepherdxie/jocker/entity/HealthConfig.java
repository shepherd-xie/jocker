package com.github.shepherdxie.jocker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * A test to perform to check that the container is healthy.
 */
@Data
public class HealthConfig {

    /**
     * The test to perform. Possible values are:
     * <ul>
     *     <li>{@code []} inherit healthcheck from image or parent image</li>
     *     <li>{@code ["NONE"]} disable healthcheck</li>
     *     <li>{@code ["CMD", args...]} exec arguments directly</li>
     *     <li>{@code ["CMD-SHELL", command]} run command with system's default shell</li>
     * </ul>
     */
    @JsonProperty("Test")
    private String[] test;

    /**
     * The time to wait between checks in nanoseconds. It should be 0 or at
     * least 1000000 (1 ms). 0 means inherit.
     */
    @JsonProperty("Interval")
    private Long interval;

    /**
     * The time to wait before considering the check to have hung. It should
     * be 0 or at least 1000000 (1 ms). 0 means inherit.
     */
    @JsonProperty("Timeout")
    private Long timeout;

    /**
     * The number of consecutive failures needed to consider a container as
     * unhealthy. 0 means inherit.
     */
    @JsonProperty("Retries")
    private Integer retries;

    /**
     * Start period for the container to initialize before starting
     * health-retries countdown in nanoseconds. It should be 0 or at least
     * 1000000 (1 ms). 0 means inherit.
     */
    @JsonProperty("StartPeriod")
    private Long startPeriod;

    /**
     * The time to wait between checks in nanoseconds during the start period.
     * It should be 0 or at least 1000000 (1 ms). 0 means inherit.
     */
    @JsonProperty("StartInterval")
    private Long startInterval;
}
