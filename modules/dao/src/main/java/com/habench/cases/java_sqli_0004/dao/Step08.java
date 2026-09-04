package com.habench.cases.java_sqli_0004.dao;

import com.habench.cases.java_sqli_0004.dao.Step09;

public final class Step08 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Step09.apply(cache);
    }
}
