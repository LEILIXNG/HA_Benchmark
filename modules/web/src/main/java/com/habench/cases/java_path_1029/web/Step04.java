package com.habench.cases.java_path_1029.web;

import com.habench.cases.java_path_1029.web.SinkHandler;

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
