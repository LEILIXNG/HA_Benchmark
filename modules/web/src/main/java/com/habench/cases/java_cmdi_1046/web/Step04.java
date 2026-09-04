package com.habench.cases.java_cmdi_1046.web;

import com.habench.cases.java_cmdi_1046.web.Step05;

public final class Step04 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step05.apply(carried);
    }
}
