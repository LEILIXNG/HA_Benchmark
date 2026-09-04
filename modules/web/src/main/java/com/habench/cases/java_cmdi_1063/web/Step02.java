package com.habench.cases.java_cmdi_1063.web;

import com.habench.cases.java_cmdi_1063.service.Gateway03;

public final class Step02 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Gateway03.apply(cache);
    }
}
