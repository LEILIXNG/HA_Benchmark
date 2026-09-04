package com.habench.cases.java_path_1006.service;

import com.habench.cases.java_path_1006.service.SinkHandler;

public final class Step03 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        SinkHandler.execute(cache);
    }
}
