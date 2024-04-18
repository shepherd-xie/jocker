package com.github.shepherdxie.jocker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * A request for devices to be sent to device drivers.
 */
@Data
public class DeviceRequest {
    /**
     * The driver.
     */
    @JsonProperty("Driver")
    private String driver;

    /**
     * The count.
     */
    @JsonProperty("Count")
    private Integer count;

    /**
     * The device IDs.
     */
    @JsonProperty("DeviceIDs")
    private List<String> deviceIDs;

    /**
     * The capabilities.
     */
    @JsonProperty("Capabilities")
    private List<List<String>> capabilities;

    /**
     * The options.
     */
    @JsonProperty("Options")
    private Map<String, String> options;
}
