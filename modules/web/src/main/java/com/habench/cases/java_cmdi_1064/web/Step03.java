package com.habench.cases.java_cmdi_1064.web;

import com.habench.cases.java_cmdi_1064.web.SinkHandler;

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
