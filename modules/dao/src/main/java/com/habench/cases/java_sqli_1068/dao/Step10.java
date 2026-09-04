package com.habench.cases.java_sqli_1068.dao;

import com.habench.cases.java_sqli_1068.dao.Step11;

public final class Step10 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Step11.apply(cache);
    }
}
