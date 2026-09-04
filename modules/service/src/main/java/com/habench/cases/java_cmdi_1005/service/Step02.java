package com.habench.cases.java_cmdi_1005.service;

import com.habench.cases.java_cmdi_1005.service.Step03;

public final class Step02 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step03.apply(carried);
    }
}
