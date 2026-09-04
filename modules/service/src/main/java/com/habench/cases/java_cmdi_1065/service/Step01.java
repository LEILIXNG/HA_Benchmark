package com.habench.cases.java_cmdi_1065.service;

import com.habench.cases.java_cmdi_1065.dao.Gateway02;

public final class Step01 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Gateway02.apply(cache);
    }
}
