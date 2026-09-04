package com.habench.cases.java_path_1036.web;

import com.habench.cases.java_path_1036.web.SinkHandler;

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
