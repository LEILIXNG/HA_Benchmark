package com.habench.cases.java_path_1013.service;

import com.habench.cases.java_path_1013.dao.Gateway02;

public final class Step01 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Gateway02.apply(cache);
    }
}
