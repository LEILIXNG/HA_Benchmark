package com.habench.cases.java_path_1013_n.service;

import com.habench.cases.java_path_1013_n.dao.Gateway02;

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
