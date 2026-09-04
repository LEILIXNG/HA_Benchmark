package com.habench.cases.java_sqli_1024_n.dao;

import com.habench.cases.java_sqli_1024_n.dao.Sanitizer04;

public final class Step03 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Sanitizer04.apply(cache);
    }
}
