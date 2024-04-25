package com.github.shepherdxie.jocker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Configuration for a container that is portable between hosts.
 *
 * <p>
 * When used as {@code ContainerConfig} field in an image, {@code ContainerConfig} is an
 * optional field containing the configuration of the container that was last
 * committed when creating the image.
 * </p>
 *
 * <p>
 * Previous versions of Docker builder used this field to store build cache,
 * and it is not in active use anymore.
 * </p>
 */
@Data
public class ContainerConfig {

    /**
     * The hostname to use for the container, as a valid RFC 1123 hostname.
     */
    @JsonProperty("Hostname")
    private String hostname;

    /**
     * The domain name to use for the container.
     */
    @JsonProperty("Domainname")
    private String domainname;

    /**
     * The user that commands are run as inside the container.
     */
    @JsonProperty("User")
    private String user;

    /**
     * Whether to attach to {@code stdin}.
     */
    @JsonProperty("AttachStdin")
    private boolean attachStdin = false;

    /**
     * Whether to attach to {@code stdout}.
     */
    @JsonProperty("AttachStdout")
    private boolean attachStdout = true;

    /**
     * Whether to attach to {@code stderr}.
     */
    @JsonProperty("AttachStderr")
    private boolean attachStderr = true;

    /**
     * An object mapping ports to an empty object in the form:
     *
     * <pre>
     * {"<port>/<tcp|udp|sctp>": {}}
     * </pre>
     */
    @JsonProperty("ExposedPorts")
    private Map<String, Object> exposedPorts;

    /**
     * Attach standard streams to a TTY, including {@code stdin} if it is not closed.
     */
    @JsonProperty("Tty")
    private boolean tty = false;

    /**
     * Open {@code stdin}.
     */
    @JsonProperty("OpenStdin")
    private boolean openStdin = false;

    /**
     * Close {@code stdin} after one attached client disconnects.
     */
    @JsonProperty("StdinOnce")
    private boolean stdinOnce = false;

    /**
     * A list of environment variables to set inside the container in the
     * form {@code ["VAR=value", ...]}. A variable without {@code =} is removed from the
     * environment, rather than to have an empty value.
     */
    @JsonProperty("Env")
    private List<String> env;

    /**
     * Command to run specified as a string or an array of strings.
     */
    @JsonProperty("Cmd")
    private List<String> cmd;

    /**
     * Healthcheck configuration.
     */
    @JsonProperty("Healthcheck")
    private HealthConfig healthcheck;

    /**
     * Command is already escaped (Windows only).
     */
    @JsonProperty("ArgsEscaped")
    private Boolean argsEscaped;

    /**
     * The name (or reference) of the image to use when creating the container,
     * or which was used when the container was created.
     */
    @JsonProperty("Image")
    private String image;

    /**
     * An object mapping mount point paths inside the container to empty
     * objects.
     */
    @JsonProperty("Volumes")
    private Map<String, Object> volumes;

    /**
     * The working directory for commands to run in.
     */
    @JsonProperty("WorkingDir")
    private String workingDir;

    /**
     * The entry point for the container as a string or an array of strings.
     *
     * <p>
     * If the array consists of exactly one empty string ({@code [""]}) then the
     * entry point is reset to system default (i.e., the entry point used by
     * docker when there is no {@code ENTRYPOINT} instruction in the {@code Dockerfile}).
     * </p>
     */
    @JsonProperty("Entrypoint")
    private List<String> entrypoint;

    /**
     * Disable networking for the container.
     */
    @JsonProperty("NetworkDisabled")
    private Boolean networkDisabled;

    /**
     * MAC address of the container.
     *
     * <p>
     * Deprecated: this field is deprecated in API v1.44 and up. Use EndpointSettings.MacAddress instead.
     * </p>
     */
    @JsonProperty("MacAddress")
    private String macAddress;

    /**
     * {@code ONBUILD} metadata that were defined in the image's {@code Dockerfile}.
     */
    @JsonProperty("OnBuild")
    private List<String> onBuild;

    /**
     * User-defined key/value metadata.
     */
    @JsonProperty("Labels")
    private Map<String, String> labels;

    /**
     * Signal to stop a container as a string or unsigned integer.
     */
    @JsonProperty("StopSignal")
    private String stopSignal;

    /**
     * Timeout to stop a container in seconds.
     */
    @JsonProperty("StopTimeout")
    private Integer stopTimeout;

    /**
     * Shell for when {@code RUN}, {@code CMD}, and {@code ENTRYPOINT} uses a shell.
     */
    @JsonProperty("Shell")
    private List<String> shell;

}
