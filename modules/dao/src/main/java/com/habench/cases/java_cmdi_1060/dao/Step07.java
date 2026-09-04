package com.habench.cases.java_cmdi_1060.dao;

import com.habench.cases.java_cmdi_1060.dao.Step08;

public final class Step07 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Step08.apply(cache);
    }
}
