package com.github.shepherdxie.jocker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author Shepherd Xie
 * @since 2024/4/17
 */
@Data
public class EndpointSettings {
    @JsonProperty("IPAMConfig")
    private EndpointIPAMConfig ipamConfig;
    @JsonProperty("MacAddress")
    private String macAddress;
    @JsonProperty("Aliases")
    private List<String> aliases;
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
    @JsonProperty("DriverOpts")
    private Map<String, String> driverOpts;
    @JsonProperty("DNSNames")
    private List<String> dnsNames;
}

