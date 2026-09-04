package com.habench.cases.java_cmdi_1022.service;

import com.habench.cases.java_cmdi_1022.service.Step07;

public final class Step06 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step07.apply(carried);
    }
}
