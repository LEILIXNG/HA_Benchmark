package com.habench.cases.java_path_1032.service;

import com.habench.cases.java_path_1032.service.Step05;

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
