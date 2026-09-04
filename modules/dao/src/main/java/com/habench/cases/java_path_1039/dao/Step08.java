package com.habench.cases.java_path_1039.dao;

import com.habench.cases.java_path_1039.dao.Sanitizer09;

public final class Step08 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Sanitizer09.apply(cache);
    }
}
