package com.habench.cases.java_path_1011.web;

import com.habench.cases.java_path_1011.service.Gateway03;

public final class Step02 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Gateway03.apply(cache);
    }
}
