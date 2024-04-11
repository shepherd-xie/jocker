package com.github.shepherdxie.jocker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Shepherd Xie
 * @since 2024/1/30
 */
@Data
public class Swarm {
    @JsonProperty("NodeID")
    private String nodeID;

    @JsonProperty("NodeAddr")
    private String nodeAddr;

    @JsonProperty("LocalNodeState")
    private String localNodeState;

    @JsonProperty("ControlAvailable")
    private boolean controlAvailable;

    @JsonProperty("Error")
    private String error;

    @JsonProperty("RemoteManagers")
    private String remoteManagers;
}
