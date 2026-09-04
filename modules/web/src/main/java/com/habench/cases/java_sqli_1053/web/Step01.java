package com.habench.cases.java_sqli_1053.web;

import com.habench.cases.java_sqli_1053.web.Step02;

public final class Step01 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Step02.apply(cache);
    }
}
