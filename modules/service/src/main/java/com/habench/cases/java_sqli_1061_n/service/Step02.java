package com.habench.cases.java_sqli_1061_n.service;

import com.habench.cases.java_sqli_1061_n.dao.Gateway03;

public final class Step02 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Gateway03.apply(cache);
    }
}
