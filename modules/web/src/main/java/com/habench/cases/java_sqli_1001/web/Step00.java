package com.habench.cases.java_sqli_1001.web;

import com.habench.cases.java_sqli_1001.service.Gateway01;

public final class Step00 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Gateway01.apply(cache);
    }
}
