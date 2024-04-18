package com.github.shepherdxie.jocker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Represents the IPAM configuration for an endpoint.
 */
@Data
public class EndpointIPAMConfig {
    /**
     * IPv4 address.
     */
    @JsonProperty("IPv4Address")
    private String ipv4Address;

    /**
     * IPv6 address.
     */
    @JsonProperty("IPv6Address")
    private String ipv6Address;

    /**
     * List of link-local IP addresses.
     */
    @JsonProperty("LinkLocalIPs")
    private List<String> linkLocalIPs;
}
