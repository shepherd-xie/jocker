package com.github.shepherdxie.jocker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Shepherd Xie
 * @since 2024/1/30
 */
@Data
public class IndexConfigs {
    @JsonProperty("Name")
    private String name;

    @JsonProperty("Mirrors")
    private String[] mirrors;

    @JsonProperty("Secure")
    private boolean secure;

    @JsonProperty("Official")
    private boolean official;
}
