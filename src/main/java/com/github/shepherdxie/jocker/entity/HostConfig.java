package com.github.shepherdxie.jocker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;

/**
 * Container configuration that depends on the host we are running on.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class HostConfig extends Resources {
    /**
     * A list of volume bindings for this container.
     */
    @JsonProperty("Binds")
    private List<String> binds;

    /**
     * Path to a file where the container ID is written.
     */
    @JsonProperty("ContainerIDFile")
    private String containerIDFile;

    /**
     * The logging configuration for this container.
     */
    @JsonProperty("LogConfig")
    private LogConfig logConfig;

    /**
     * Network mode to use for this container.
     */
    @JsonProperty("NetworkMode")
    private String networkMode;

    /**
     * Port bindings for this container.
     */
    @JsonProperty("PortBindings")
    private PortMap portBindings;

    /**
     * Restart policy for this container.
     */
    @JsonProperty("RestartPolicy")
    private RestartPolicy restartPolicy;

    /**
     * Automatically remove the container when the container's process exits.
     */
    @JsonProperty("AutoRemove")
    private Boolean autoRemove;

    /**
     * Driver that this container uses to mount volumes.
     */
    @JsonProperty("VolumeDriver")
    private String volumeDriver;

    /**
     * A list of volumes to inherit from another container.
     */
    @JsonProperty("VolumesFrom")
    private List<String> volumesFrom;

    /**
     * Specification for mounts to be added to the container.
     */
    @JsonProperty("Mounts")
    private List<Mount> mounts;

    /**
     * Initial console size.
     */
    @JsonProperty("ConsoleSize")
    private List<Integer> consoleSize;

    /**
     * Arbitrary non-identifying metadata attached to container.
     */
    @JsonProperty("Annotations")
    private Map<String, String> annotations;
}
