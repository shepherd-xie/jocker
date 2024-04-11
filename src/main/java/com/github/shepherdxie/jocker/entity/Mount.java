package com.github.shepherdxie.jocker.entity;

import lombok.Data;

/**
 * @author Shepherd Xie
 * @since 2024/4/10
 */
@Data
class Mount {
    private String name;
    private String source;
    private String destination;
    private String driver;
    private String mode;
    private boolean rw;
    private String propagation;
}
