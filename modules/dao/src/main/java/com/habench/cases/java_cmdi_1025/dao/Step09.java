package com.habench.cases.java_cmdi_1025.dao;

import com.habench.cases.java_cmdi_1025.dao.SinkHandler;

public final class Step09 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        SinkHandler.execute(cache);
    }
}
