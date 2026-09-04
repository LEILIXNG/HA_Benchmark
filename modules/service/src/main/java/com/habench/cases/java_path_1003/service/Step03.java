package com.habench.cases.java_path_1003.service;

import com.habench.cases.java_path_1003.service.Step04;

public final class Step03 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Step04.apply(cache);
    }
}
