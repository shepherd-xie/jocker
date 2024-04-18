package com.github.shepherdxie.jocker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Represents a throttle device.
 */
@Data
public class ThrottleDevice {
    /**
     * Device path.
     */
    @JsonProperty("Path")
    private String path;

    /**
     * Rate.
     */
    @JsonProperty("Rate")
    private long rate;
}
