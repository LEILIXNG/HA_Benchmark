package com.habench.cases.java_path_1041.service;

import com.habench.cases.java_path_1041.service.Step03;

public final class Step02 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Step03.apply(cache);
    }
}
