package com.habench.cases.java_cmdi_1012.web;

import com.habench.cases.java_cmdi_1012.web.Sanitizer05;

public final class Step04 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Sanitizer05.apply(cache);
    }
}
