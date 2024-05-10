package com.github.shepherdxie.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Shepherd Xie
 * @since 2024/4/25
 */
public class ShellUtil {

    public static String wrap(String s) {
        return StringUtils.wrap(s, '"');
    }

}
