package com.habench.cases.java_sqli_1026.web;

import com.habench.cases.java_sqli_1026.service.Gateway02;

public final class Step01 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Gateway02.apply(cache);
    }
}
