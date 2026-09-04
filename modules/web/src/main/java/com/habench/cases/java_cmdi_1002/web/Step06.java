package com.habench.cases.java_cmdi_1002.web;

import com.habench.cases.java_cmdi_1002.service.Gateway07;

public final class Step06 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Gateway07.apply(cache);
    }
}
