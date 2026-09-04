package com.habench.cases.java_sqli_1068.dao;

import com.habench.cases.java_sqli_1068.dao.Sanitizer12;

public final class Step11 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Sanitizer12.apply(cache);
    }
}
