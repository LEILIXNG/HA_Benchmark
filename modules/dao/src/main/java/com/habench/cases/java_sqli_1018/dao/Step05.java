package com.habench.cases.java_sqli_1018.dao;

import com.habench.cases.java_sqli_1018.dao.Sanitizer06;

public final class Step05 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Sanitizer06.apply(cache);
    }
}
