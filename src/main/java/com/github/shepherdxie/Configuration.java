package com.github.shepherdxie;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Shepherd Xie
 * @since 2024/3/18
 */
public class Configuration {
    static Properties properties = new Properties();

    static {
        InputStream stream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("security/config.properties");
        try {
            properties.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static <T> T get(String key, Class<T> tClass) {
        return tClass.cast(properties.getProperty(key));
    }
}
