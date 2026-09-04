package com.habench.cases.java_sqli_1022_n.dao;

import com.habench.cases.java_sqli_1022_n.dao.Sanitizer10;

public final class Step09 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Sanitizer10.apply(cache);
    }
}
