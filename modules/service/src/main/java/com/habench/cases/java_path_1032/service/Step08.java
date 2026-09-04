package com.habench.cases.java_path_1032.service;

import com.habench.cases.java_path_1032.service.SinkHandler;

public final class Step08 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        SinkHandler.execute(cache);
    }
}
