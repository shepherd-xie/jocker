package com.github.shepherdxie.jocker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Represents the configuration for a network endpoint.
 */
@Data
public class EndpointSettings {
    /**
     * Configuration for IP Address Management (IPAM).
     */
    @JsonProperty("IPAMConfig")
    private EndpointIPAMConfig ipamConfig;

    /**
     * List of links to other containers.
     */
    @JsonProperty("Links")
    private List<String> links;

    /**
     * MAC address for the endpoint on this network. The network driver might ignore this parameter.
     */
    @JsonProperty("MacAddress")
    private String macAddress;

    /**
     * List of network aliases.
     */
    @JsonProperty("Aliases")
    private List<String> aliases;

    /**
     * Unique ID of the network.
     */
    @JsonProperty("NetworkID")
    private String networkID;

    /**
     * Unique ID for the service endpoint in a Sandbox.
     */
    @JsonProperty("EndpointID")
    private String endpointID;

    /**
     * Gateway address for this network.
     */
    @JsonProperty("Gateway")
    private String gateway;

    /**
     * IPv4 address.
     */
    @JsonProperty("IPAddress")
    private String ipAddress;

    /**
     * Mask length of the IPv4 address.
     */
    @JsonProperty("IPPrefixLen")
    private Integer ipPrefixLen;

    /**
     * IPv6 gateway address.
     */
    @JsonProperty("IPv6Gateway")
    private String ipv6Gateway;

    /**
     * Global IPv6 address.
     */
    @JsonProperty("GlobalIPv6Address")
    private String globalIPv6Address;

    /**
     * Mask length of the global IPv6 address.
     */
    @JsonProperty("GlobalIPv6PrefixLen")
    private Long globalIPv6PrefixLen;

    /**
     * Driver options as a mapping of driver options and values.
     */
    @JsonProperty("DriverOpts")
    private Map<String, String> driverOpts;

    /**
     * List of all DNS names an endpoint has on a specific network.
     */
    @JsonProperty("DNSNames")
    private List<String> dnsNames;
}
