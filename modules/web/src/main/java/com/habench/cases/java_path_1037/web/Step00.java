package com.habench.cases.java_path_1037.web;

import com.habench.cases.java_path_1037.service.Gateway01;

public final class Step00 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Gateway01.apply(cache);
    }
}
