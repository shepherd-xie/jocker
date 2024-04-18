package com.github.shepherdxie.jocker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * A device mapping between the host and container.
 */
@Data
public class DeviceMapping {
    /**
     * Path on the host.
     */
    @JsonProperty("PathOnHost")
    private String pathOnHost;

    /**
     * Path in the container.
     */
    @JsonProperty("PathInContainer")
    private String pathInContainer;

    /**
     * Cgroup permissions.
     */
    @JsonProperty("CgroupPermissions")
    private String cgroupPermissions;
}
