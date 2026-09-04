package com.habench.cases.java_sqli_1028.dao;

import com.habench.cases.java_sqli_1028.dao.SinkHandler;

public final class Step07 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        SinkHandler.execute(cache);
    }
}
