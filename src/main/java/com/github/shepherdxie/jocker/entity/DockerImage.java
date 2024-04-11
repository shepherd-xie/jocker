package com.github.shepherdxie.jocker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class DockerImage {
    private String id;

    @JsonProperty("ParentId")
    private String parentId;

    @JsonProperty("RepoTags")
    private List<String> repoTags;

    @JsonProperty("RepoDigests")
    private List<String> repoDigests;

    private String created;
    private long size;

    @JsonProperty("SharedSize")
    private long sharedSize;

    @JsonProperty("VirtualSize")
    private long virtualSize;

    private Map<String, String> labels;

    private int containers;
}
