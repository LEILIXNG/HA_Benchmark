package com.habench.cases.java_sqli_1042.web;

import com.habench.cases.java_sqli_1042.service.Gateway04;

public final class Step03 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Gateway04.apply(cache);
    }
}
