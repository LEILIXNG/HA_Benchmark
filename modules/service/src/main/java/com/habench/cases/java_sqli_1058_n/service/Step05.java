package com.habench.cases.java_sqli_1058_n.service;

import com.habench.cases.java_sqli_1058_n.service.Step06;

public final class Step05 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Step06.apply(cache);
    }
}
