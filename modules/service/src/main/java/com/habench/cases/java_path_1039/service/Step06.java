package com.habench.cases.java_path_1039.service;

import com.habench.cases.java_path_1039.dao.Gateway07;

public final class Step06 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Gateway07.apply(cache);
    }
}
