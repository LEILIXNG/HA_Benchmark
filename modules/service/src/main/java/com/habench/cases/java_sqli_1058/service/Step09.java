package com.habench.cases.java_sqli_1058.service;

import com.habench.cases.java_sqli_1058.dao.Gateway10;

public final class Step09 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Gateway10.apply(cache);
    }
}
