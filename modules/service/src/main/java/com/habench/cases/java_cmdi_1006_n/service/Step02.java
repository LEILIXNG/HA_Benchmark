package com.habench.cases.java_cmdi_1006_n.service;

import com.habench.cases.java_cmdi_1006_n.service.Sanitizer03;

public final class Step02 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Sanitizer03.apply(cache);
    }
}
