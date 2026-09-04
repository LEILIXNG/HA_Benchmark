package com.habench.cases.java_cmdi_1056.web;

import com.habench.cases.java_cmdi_1056.web.Step01;

public final class Step00 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step01.apply(carried);
    }
}
