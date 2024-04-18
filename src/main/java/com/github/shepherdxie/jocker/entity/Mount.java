package com.github.shepherdxie.jocker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

/**
 * Represents a mount configuration.
 */
@Data
public class Mount {
    /**
     * Container path.
     */
    @JsonProperty("Target")
    private String target;

    /**
     * Mount source (e.g. a volume name, a host path).
     */
    @JsonProperty("Source")
    private String source;

    /**
     * The mount type.
     * Available types:
     * - `bind` Mounts a file or directory from the host into the container. Must exist prior to creating the container.
     * - `volume` Creates a volume with the given name and options (or uses a pre-existing volume with the same name and options). These are **not** removed when the container is removed.
     * - `tmpfs` Create a tmpfs with the given options. The mount source cannot be specified for tmpfs.
     * - `npipe` Mounts a named pipe from the host into the container. Must exist prior to creating the container.
     * - `cluster` a Swarm cluster volume
     */
    @JsonProperty("Type")
    private String type;

    /**
     * Whether the mount should be read-only.
     */
    @JsonProperty("ReadOnly")
    private boolean readOnly;

    /**
     * The consistency requirement for the mount: `default`, `consistent`, `cached`, or `delegated`.
     */
    @JsonProperty("Consistency")
    private String consistency;

    /**
     * Optional configuration for the `bind` type.
     */
    @JsonProperty("BindOptions")
    private BindOptions bindOptions;

    /**
     * Optional configuration for the `volume` type.
     */
    @JsonProperty("VolumeOptions")
    private VolumeOptions volumeOptions;

    /**
     * Optional configuration for the `tmpfs` type.
     */
    @JsonProperty("TmpfsOptions")
    private TmpfsOptions tmpfsOptions;

    /**
     * Represents optional configuration for the `bind` type.
     */
    @Data
    public static class BindOptions {
        /**
         * A propagation mode with the value `[r]private`, `[r]shared`, or `[r]slave`.
         */
        @JsonProperty("Propagation")
        private String propagation;

        /**
         * Disable recursive bind mount.
         */
        @JsonProperty("NonRecursive")
        private boolean nonRecursive;

        /**
         * Create mount point on host if missing.
         */
        @JsonProperty("CreateMountpoint")
        private boolean createMountpoint;

        /**
         * Make the mount non-recursively read-only, but still leave the mount recursive
         * (unless NonRecursive is set to true in conjunction).
         */
        @JsonProperty("ReadOnlyNonRecursive")
        private boolean readOnlyNonRecursive;

        /**
         * Raise an error if the mount cannot be made recursively read-only.
         */
        @JsonProperty("ReadOnlyForceRecursive")
        private boolean readOnlyForceRecursive;
    }

    /**
     * Represents optional configuration for the `volume` type.
     */
    @Data
    public static class VolumeOptions {
        /**
         * Populate volume with data from the target.
         */
        @JsonProperty("NoCopy")
        private boolean noCopy;

        /**
         * User-defined key/value metadata.
         */
        @JsonProperty("Labels")
        private Map<String, String> labels;

        /**
         * Map of driver specific options.
         */
        @JsonProperty("DriverConfig")
        private DriverConfig driverConfig;

        /**
         * Represents driver specific options.
         */
        @Data
        public static class DriverConfig {
            /**
             * Name of the driver to use to create the volume.
             */
            @JsonProperty("Name")
            private String name;

            /**
             * Key/value map of driver specific options.
             */
            @JsonProperty("Options")
            private Map<String, String> options;
        }
    }

    /**
     * Represents optional configuration for the `tmpfs` type.
     */
    @Data
    public static class TmpfsOptions {
        /**
         * The size for the tmpfs mount in bytes.
         */
        @JsonProperty("SizeBytes")
        private long sizeBytes;

        /**
         * The permission mode for the tmpfs mount in an integer.
         */
        @JsonProperty("Mode")
        private int mode;
    }
}
