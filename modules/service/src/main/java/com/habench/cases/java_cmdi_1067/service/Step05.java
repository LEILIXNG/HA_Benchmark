package com.habench.cases.java_cmdi_1067.service;

import com.habench.cases.java_cmdi_1067.dao.Gateway06;

public final class Step05 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Gateway06.apply(cache);
    }
}
