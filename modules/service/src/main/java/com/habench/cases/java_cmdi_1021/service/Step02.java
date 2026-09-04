package com.habench.cases.java_cmdi_1021.service;

import com.habench.cases.java_cmdi_1021.service.SinkHandler;

public final class Step02 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        SinkHandler.execute(cache);
    }
}
