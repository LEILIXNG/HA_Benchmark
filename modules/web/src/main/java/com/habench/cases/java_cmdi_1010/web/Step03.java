package com.habench.cases.java_cmdi_1010.web;

import com.habench.cases.java_cmdi_1010.web.SinkHandler;

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
