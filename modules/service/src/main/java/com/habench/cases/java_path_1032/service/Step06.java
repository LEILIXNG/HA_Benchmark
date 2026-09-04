package com.habench.cases.java_path_1032.service;

import com.habench.cases.java_path_1032.service.Step07;

public final class Step06 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Step07.apply(cache);
    }
}
