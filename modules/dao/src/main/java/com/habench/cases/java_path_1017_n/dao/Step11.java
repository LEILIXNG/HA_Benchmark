package com.habench.cases.java_path_1017_n.dao;

import com.habench.cases.java_path_1017_n.dao.Sanitizer12;

public final class Step11 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Sanitizer12.apply(cache);
    }
}
