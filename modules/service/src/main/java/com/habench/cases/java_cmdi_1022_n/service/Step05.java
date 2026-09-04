package com.habench.cases.java_cmdi_1022_n.service;

import com.habench.cases.java_cmdi_1022_n.service.Step06;

public final class Step05 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step06.apply(carried);
    }
}
