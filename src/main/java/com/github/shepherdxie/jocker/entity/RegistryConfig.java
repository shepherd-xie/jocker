package com.github.shepherdxie.jocker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * @author Shepherd Xie
 * @since 2024/1/30
 */
public class RegistryConfig {
    @JsonProperty("AllowNondistributableArtifactsCIDRs")
    private String allowNondistributableArtifactsCIDRs;

    @JsonProperty("AllowNondistributableArtifactsHostnames")
    private String allowNondistributableArtifactsHostnames;

    @JsonProperty("InsecureRegistryCIDRs")
    private String[] insecureRegistryCIDRs;

    @JsonProperty("IndexConfigs")
    private Map<String, IndexConfigs> indexConfigs;

    @JsonProperty("Mirrors")
    private String mirrors;
}
