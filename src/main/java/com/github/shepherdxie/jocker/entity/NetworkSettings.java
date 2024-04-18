package com.github.shepherdxie.jocker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

/**
 * Represents the network settings exposed in the API.
 */
@Data
public class NetworkSettings {
    /**
     * Name of the default bridge interface when dockerd's --bridge flag is set.
     */
    @JsonProperty("Bridge")
    private String bridge;

    /**
     * SandboxID uniquely represents a container's network stack.
     */
    @JsonProperty("SandboxID")
    private String sandboxID;

    /**
     * Indicates if hairpin NAT should be enabled on the virtual interface.
     * Deprecated: This field is never set and will be removed in a future release.
     */
    @JsonProperty("HairpinMode")
    private boolean hairpinMode;

    /**
     * IPv6 unicast address using the link-local prefix.
     * Deprecated: This field is never set and will be removed in a future release.
     */
    @JsonProperty("LinkLocalIPv6Address")
    private String linkLocalIPv6Address;

    /**
     * Prefix length of the IPv6 unicast address.
     * Deprecated: This field is never set and will be removed in a future release.
     */
    @JsonProperty("LinkLocalIPv6PrefixLen")
    private int linkLocalIPv6PrefixLen;

    /**
     * Container exposed ports.
     */
    @JsonProperty("Ports")
    private Map<String, Map<String, String>> ports;

    /**
     * SandboxKey is the full path of the netns handle.
     */
    @JsonProperty("SandboxKey")
    private String sandboxKey;

    /**
     * Deprecated: This field is never set and will be removed in a future release.
     */
    @JsonProperty("SecondaryIPAddresses")
    private String[] secondaryIPAddresses;

    /**
     * Deprecated: This field is never set and will be removed in a future release.
     */
    @JsonProperty("SecondaryIPv6Addresses")
    private String[] secondaryIPv6Addresses;

    /**
     * EndpointID uniquely represents a service endpoint in a Sandbox.
     * Deprecated: This field is only propagated when attached to the default "bridge" network. Use the information from the "bridge" network inside the {@code Networks} map instead, which contains the same information. This field was deprecated in Docker 1.9 and is scheduled to be removed in Docker 17.12.0.
     */
    @JsonProperty("EndpointID")
    private String endpointID;

    /**
     * Gateway address for the default "bridge" network.
     * Deprecated: This field is only propagated when attached to the default "bridge" network. Use the information from the "bridge" network inside the {@code Networks} map instead, which contains the same information. This field was deprecated in Docker 1.9 and is scheduled to be removed in Docker 17.12.0.
     */
    @JsonProperty("Gateway")
    private String gateway;

    /**
     * Global IPv6 address for the default "bridge" network.
     * Deprecated: This field is only propagated when attached to the default "bridge" network. Use the information from the "bridge" network inside the {@code Networks} map instead, which contains the same information. This field was deprecated in Docker 1.9 and is scheduled to be removed in Docker 17.12.0.
     */
    @JsonProperty("GlobalIPv6Address")
    private String globalIPv6Address;

    /**
     * Mask length of the global IPv6 address.
     * Deprecated: This field is only propagated when attached to the default "bridge" network. Use the information from the "bridge" network inside the {@code Networks} map instead, which contains the same information. This field was deprecated in Docker 1.9 and is scheduled to be removed in Docker 17.12.0.
     */
    @JsonProperty("GlobalIPv6PrefixLen")
    private int globalIPv6PrefixLen;

    /**
     * IPv4 address for the default "bridge" network.
     * Deprecated: This field is only propagated when attached to the default "bridge" network. Use the information from the "bridge" network inside the {@code Networks} map instead, which contains the same information. This field was deprecated in Docker 1.9 and is scheduled to be removed in Docker 17.12.0.
     */
    @JsonProperty("IPAddress")
    private String ipAddress;

    /**
     * Mask length of the IPv4 address.
     * Deprecated: This field is only propagated when attached to the default "bridge" network. Use the information from the "bridge" network inside the {@code Networks} map instead, which contains the same information. This field was deprecated in Docker 1.9 and is scheduled to be removed in Docker 17.12.0.
     */
    @JsonProperty("IPPrefixLen")
    private int ipPrefixLen;

    /**
     * IPv6 gateway address for this network.
     * Deprecated: This field is only propagated when attached to the default "bridge" network. Use the information from the "bridge" network inside the {@code Networks} map instead, which contains the same information. This field was deprecated in Docker 1.9 and is scheduled to be removed in Docker 17.12.0.
     */
    @JsonProperty("IPv6Gateway")
    private String ipv6Gateway;

    /**
     * MAC address for the container on the default "bridge" network.
     * Deprecated: This field is only propagated when attached to the default "bridge" network. Use the information from the "bridge" network inside the {@code Networks} map instead, which contains the same information. This field was deprecated in Docker 1.9 and is scheduled to be removed in Docker 17.12.0.
     */
    @JsonProperty("MacAddress")
    private String macAddress;

    /**
     * Information about all networks that the container is connected to.
     */
    @JsonProperty("Networks")
    private Map<String, EndpointSettings> networks;
}
