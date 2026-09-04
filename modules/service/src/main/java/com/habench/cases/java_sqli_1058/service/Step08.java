package com.habench.cases.java_sqli_1058.service;

import com.habench.cases.java_sqli_1058.service.Step09;

public final class Step08 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step09.apply(carried);
    }
}
