package com.habench.cases.java_sqli_1058.service;

import com.habench.cases.java_sqli_1058.service.Step08;

public final class Step07 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Step08.apply(cache);
    }
}
