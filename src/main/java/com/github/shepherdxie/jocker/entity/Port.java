package com.github.shepherdxie.jocker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * An open port on a container.
 */
@Data
public class Port {
    /**
     * Host IP address that the container's port is mapped to.
     */
    @JsonProperty("IP")
    private String ip;

    /**
     * Port on the container.
     */
    @JsonProperty("PrivatePort")
    private int privatePort;

    /**
     * Port exposed on the host.
     */
    @JsonProperty("PublicPort")
    private int publicPort;

    /**
     * Type of the port (tcp, udp, sctp).
     */
    @JsonProperty("Type")
    private String type;
}
