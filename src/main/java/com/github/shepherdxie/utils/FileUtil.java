package com.github.shepherdxie.utils;

import java.nio.file.Path;

/**
 * @author Shepherd Xie
 * @since 2024/4/9
 */
public class FileUtil {
    private static final String RESOURCE_PATH = Path.of("src", "main", "resources").toString();

    public static String getResource(String... paths) {

        if (paths == null) {
            return RESOURCE_PATH;
        }
        return Path.of(RESOURCE_PATH, paths).toString();
    }

}
