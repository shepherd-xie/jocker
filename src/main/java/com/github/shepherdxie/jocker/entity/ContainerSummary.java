package com.github.shepherdxie.jocker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Summary information about a container.
 */
@Data
public class ContainerSummary {
    /**
     * The ID of this container.
     */
    @JsonProperty("Id")
    private String id;

    /**
     * The names that this container has been given.
     */
    @JsonProperty("Names")
    private List<String> names;

    /**
     * The name of the image used when creating this container.
     */
    @JsonProperty("Image")
    private String image;

    /**
     * The ID of the image that this container was created from.
     */
    @JsonProperty("ImageID")
    private String imageID;

    /**
     * Command to run when starting the container.
     */
    @JsonProperty("Command")
    private String command;

    /**
     * When the container was created.
     */
    @JsonProperty("Created")
    private Long created;

    /**
     * The ports exposed by this container.
     */
    @JsonProperty("Ports")
    private List<Port> ports;

    /**
     * The size of files that have been created or changed by this container.
     */
    @JsonProperty("SizeRw")
    private Long sizeRw;

    /**
     * The total size of all the files in this container.
     */
    @JsonProperty("SizeRootFs")
    private Long sizeRootFs;

    /**
     * User-defined key/value metadata.
     */
    @JsonProperty("Labels")
    private Map<String, String> labels;

    /**
     * The state of this container (e.g. `Exited`).
     */
    @JsonProperty("State")
    private String state;

    /**
     * Additional human-readable status of this container (e.g. `Exit 0`).
     */
    @JsonProperty("Status")
    private String status;

    /**
     * Host configuration for the container.
     */
    @JsonProperty("HostConfig")
    private HostConfig hostConfig;

    /**
     * A summary of the container's network settings.
     */
    @JsonProperty("NetworkSettings")
    private NetworkSettings networkSettings;

    /**
     * A list of mount points.
     */
    @JsonProperty("Mounts")
    private List<MountPoint> mounts;
}
