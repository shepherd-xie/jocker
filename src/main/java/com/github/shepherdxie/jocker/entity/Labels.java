package com.github.shepherdxie.jocker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Shepherd Xie
 * @since 2024/4/10
 */
@Data
class Labels {
    @JsonProperty("com.example.vendor")
    private String vendor;

    @JsonProperty("com.example.license")
    private String license;

    @JsonProperty("com.example.version")
    private String version;
}
