package com.habench.cases.java_sqli_1019.service;

import com.habench.cases.java_sqli_1019.dao.Gateway05;

public final class Step04 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Gateway05.apply(cache);
    }
}
