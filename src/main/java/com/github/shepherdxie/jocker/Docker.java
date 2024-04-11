package com.github.shepherdxie.jocker;

import com.github.shepherdxie.jocker.entity.DockerInfo;
import com.github.shepherdxie.jocker.entity.InfoOptions;

/**
 * @author Shepherd Xie
 * @since 2024/1/30
 */
public interface Docker {

    DockerInfo info(InfoOptions infoOptions);

}
