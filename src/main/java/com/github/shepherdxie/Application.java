package com.github.shepherdxie;

import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.TreeSet;

/**
 * @author Shepherd Xie
 * @since 2024/5/16
 */
public class Application {
    public static void main(String[] args) {
        String s = "";
        System.out.println(Optional.ofNullable(s).filter(StringUtils::isNotBlank).map(BigDecimal::new).orElse(BigDecimal.ZERO));
    }

}

@Data
class Bar {
    int yr;
    int qt;

    static Bar of(int yr, int qt) {
        Bar bar = new Bar();
        bar.yr = yr;
        bar.qt = qt;
        return bar;
    }
}