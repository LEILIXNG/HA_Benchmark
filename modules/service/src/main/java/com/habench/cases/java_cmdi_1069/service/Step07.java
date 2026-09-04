package com.habench.cases.java_cmdi_1069.service;

import com.habench.cases.java_cmdi_1069.service.Sanitizer08;

public final class Step07 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Sanitizer08.apply(cache);
    }
}
