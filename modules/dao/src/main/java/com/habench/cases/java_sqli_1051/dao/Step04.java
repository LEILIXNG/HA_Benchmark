package com.habench.cases.java_sqli_1051.dao;

import com.habench.cases.java_sqli_1051.dao.SinkHandler;

public final class Step04 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        SinkHandler.execute(cache);
    }
}
