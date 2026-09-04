package com.habench.cases.java_sqli_1060.service;

import com.habench.cases.java_sqli_1060.dao.Gateway11;

public final class Step10 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Gateway11.apply(cache);
    }
}
