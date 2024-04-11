package com.github.shepherdxie.jocker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DockerContainer {
    private String id;
    private List<String> names;
    private String image;
    @JsonProperty("ImageID")
    private String imageID;
    private String command;
    private long created;
    private String state;
    private String status;
    private List<Port> ports;
    private Labels labels;
    @JsonProperty("SizeRw")
    private int sizeRw;
    @JsonProperty("SizeRootFs")
    private int sizeRootFs;
    @JsonProperty("HostConfig")
    private HostConfig hostConfig;
    @JsonProperty("NetworkSettings")
    private NetworkSettings networkSettings;
    private List<Mount> mounts;
}

