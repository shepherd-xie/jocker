package com.github.shepherdxie.jocker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Shepherd Xie
 * @since 2024/4/10
 */
@Data
class Bridge {
    @JsonProperty("NetworkID")
    private String networkID;

    @JsonProperty("EndpointID")
    private String endpointID;

    @JsonProperty("Gateway")
    private String gateway;

    @JsonProperty("IPAddress")
    private String ipAddress;

    @JsonProperty("IPPrefixLen")
    private int ipPrefixLen;

    @JsonProperty("IPv6Gateway")
    private String ipv6Gateway;

    @JsonProperty("GlobalIPv6Address")
    private String globalIPv6Address;

    @JsonProperty("GlobalIPv6PrefixLen")
    private int globalIPv6PrefixLen;

    @JsonProperty("MacAddress")
    private String macAddress;
}
