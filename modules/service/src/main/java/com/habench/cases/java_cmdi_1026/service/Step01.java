package com.habench.cases.java_cmdi_1026.service;

import com.habench.cases.java_cmdi_1026.service.Step02;

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
