package com.habench.cases.java_sqli_1030.web;

import com.habench.cases.java_sqli_1030.web.Step04;

public final class Step03 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Step04.apply(cache);
    }
}
