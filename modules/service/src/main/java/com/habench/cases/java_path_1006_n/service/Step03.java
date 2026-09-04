package com.habench.cases.java_path_1006_n.service;

import com.habench.cases.java_path_1006_n.service.Sanitizer04;

public final class Step03 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Sanitizer04.apply(cache);
    }
}
