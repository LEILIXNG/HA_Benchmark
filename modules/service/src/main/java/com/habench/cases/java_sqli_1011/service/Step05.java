package com.habench.cases.java_sqli_1011.service;

import com.habench.cases.java_sqli_1011.service.Step06;

public final class Step05 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step06.apply(carried);
    }
}
