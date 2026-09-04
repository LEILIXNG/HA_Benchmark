package com.habench.cases.java_cmdi_1017_n.dao;

import com.habench.cases.java_cmdi_1017_n.dao.Step06;

public final class Step05 {
    private static String cache;

    public static void apply(String value) {
        cache = value;
        drain();
    }

    private static void drain() {
        Step06.apply(cache);
    }
}
