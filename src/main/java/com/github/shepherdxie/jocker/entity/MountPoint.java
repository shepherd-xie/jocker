package com.github.shepherdxie.jocker.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * MountPoint represents a mount point configuration inside the container.
 * This is used for reporting the mountpoints in use by a container.
 */
@Data
public class MountPoint {
    /**
     * The mount type:
     * <ul>
     *     <li><code>bind</code>: a mount of a file or directory from the host into the container.</li>
     *     <li><code>volume</code>: a docker volume with the given <code>Name</code>.</li>
     *     <li><code>tmpfs</code>: a <code>tmpfs</code>.</li>
     *     <li><code>npipe</code>: a named pipe from the host into the container.</li>
     *     <li><code>cluster</code>: a Swarm cluster volume.</li>
     * </ul>
     */
    @JsonProperty("Type")
    private String type;

    /**
     * Name is the name reference to the underlying data defined by <code>Source</code>
     * e.g., the volume name.
     */
    @JsonProperty("Name")
    private String name;

    /**
     * Source location of the mount.
     * <p>
     * For volumes, this contains the storage location of the volume (within
     * <code>/var/lib/docker/volumes/</code>). For bind-mounts, and <code>npipe</code>, this contains
     * the source (host) part of the bind-mount. For <code>tmpfs</code> mount points, this
     * field is empty.
     */
    @JsonProperty("Source")
    private String source;

    /**
     * Destination is the path relative to the container root (<code>/</code>) where
     * the <code>Source</code> is mounted inside the container.
     */
    @JsonProperty("Destination")
    private String destination;

    /**
     * Driver is the volume driver used to create the volume (if it is a volume).
     */
    @JsonProperty("Driver")
    private String driver;

    /**
     * Mode is a comma separated list of options supplied by the user when
     * creating the bind/volume mount.
     * <p>
     * The default is platform-specific (<code>"z"</code> on Linux, empty on Windows).
     */
    @JsonProperty("Mode")
    private String mode;

    /**
     * Whether the mount is mounted writable (read-write).
     */
    @JsonProperty("RW")
    private boolean rw;

    /**
     * Propagation describes how mounts are propagated from the host into the
     * mount point, and vice-versa. Refer to the Linux kernel documentation
     * for details. This field is not used on Windows.
     */
    @JsonProperty("Propagation")
    private String propagation;
}
