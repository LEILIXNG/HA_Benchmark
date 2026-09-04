package com.habench.cases.java_cmdi_1064_n.web;

import com.habench.cases.java_cmdi_1064_n.web.Sanitizer04;

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
