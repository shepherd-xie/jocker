package com.github.shepherdxie.jocker.entity;

import lombok.Data;

import java.util.Map;

/**
 * @author Shepherd Xie
 * @since 2024/4/17
 */
@Data
class NetworkSettings {
    private Map<String, EndpointSettings> networks;
}
