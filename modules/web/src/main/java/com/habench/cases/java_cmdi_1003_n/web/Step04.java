package com.habench.cases.java_cmdi_1003_n.web;

import com.habench.cases.java_cmdi_1003_n.web.Step05;

public final class Step04 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Step05.apply(cache);
    }
}
