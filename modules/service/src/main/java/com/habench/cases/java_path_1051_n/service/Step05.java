package com.habench.cases.java_path_1051_n.service;

import com.habench.cases.java_path_1051_n.dao.Gateway06;

public final class Step05 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Gateway06.apply(cache);
    }
}
