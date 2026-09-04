package com.habench.cases.java_sqli_1070.service;

import com.habench.cases.java_sqli_1070.service.Step11;

public final class Step10 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step11.apply(carried);
    }
}
