package com.github.shepherdxie.jocker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Shepherd Xie
 * @since 2024/4/10
 */
@Data
class Port {
    @JsonProperty("PrivatePort")
    private int privatePort;

    @JsonProperty("PublicPort")
    private int publicPort;

    @JsonProperty("Type")
    private String type;
}
