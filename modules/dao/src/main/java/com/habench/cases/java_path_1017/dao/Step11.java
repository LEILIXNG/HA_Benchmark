package com.habench.cases.java_path_1017.dao;

import com.habench.cases.java_path_1017.dao.SinkHandler;

public final class Step11 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        SinkHandler.execute(cache);
    }
}
