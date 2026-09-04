package com.habench.cases.java_cmdi_1014.web;

import com.habench.cases.java_cmdi_1014.web.Step04;

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
