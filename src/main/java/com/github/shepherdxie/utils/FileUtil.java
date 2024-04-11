package com.github.shepherdxie.utils;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

/**
 * @author Shepherd Xie
 * @since 2024/4/9
 */
public class FileUtil {
    private static final String RESOURCE_PATH = Path.of("src", "main", "resources").toString();
    private static final Properties SECURITY_CONFIG = new Properties();

    static {
        try {
            SECURITY_CONFIG.load(new FileReader(getSecurity("config.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getResource(String path, String... others) {
        if (path == null) {
            return RESOURCE_PATH;
        }

        return Path.of(RESOURCE_PATH, Path.of(path, others).toString()).toString();
    }

    public static String getSecurity(String... paths) {
        return getResource("security", paths);
    }

    public static String getSecurityConfig(String key) {
        return SECURITY_CONFIG.get(key).toString();
    }

}
