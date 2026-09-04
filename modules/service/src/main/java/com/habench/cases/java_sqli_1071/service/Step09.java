package com.habench.cases.java_sqli_1071.service;

import com.habench.cases.java_sqli_1071.service.Step10;

public final class Step09 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Step10.apply(cache);
    }
}
