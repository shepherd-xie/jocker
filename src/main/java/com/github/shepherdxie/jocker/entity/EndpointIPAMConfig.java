package com.github.shepherdxie.jocker.entity;

import lombok.Data;

import java.util.List;

/**
 * @author Shepherd Xie
 * @since 2024/4/17
 */
@Data
class EndpointIPAMConfig {
    private String ipv4Address;
    private String ipv6Address;
    private List<String> linkLocalIPs;
    private List<String> links;
}
