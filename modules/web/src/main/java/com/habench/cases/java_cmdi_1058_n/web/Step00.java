package com.habench.cases.java_cmdi_1058_n.web;

import com.habench.cases.java_cmdi_1058_n.web.Step01;

public final class Step00 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Step01.apply(cache);
    }
}
