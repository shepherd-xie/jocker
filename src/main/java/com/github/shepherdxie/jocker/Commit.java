package com.github.shepherdxie.jocker;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Shepherd Xie
 * @since 2024/1/30
 */
@Data
public class Commit {
    @JsonProperty("ID")
    private String id;

    @JsonProperty("Created")
    private String created;

    @JsonProperty("Expected")
    private String expected;
}
