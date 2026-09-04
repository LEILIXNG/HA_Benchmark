package com.habench.cases.java_sqli_1047.service;

import com.habench.cases.java_sqli_1047.service.SinkHandler;

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
