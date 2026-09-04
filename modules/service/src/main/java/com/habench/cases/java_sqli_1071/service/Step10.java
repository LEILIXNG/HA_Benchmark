package com.habench.cases.java_sqli_1071.service;

import com.habench.cases.java_sqli_1071.service.SinkHandler;

public final class Step10 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        SinkHandler.execute(cache);
    }
}
