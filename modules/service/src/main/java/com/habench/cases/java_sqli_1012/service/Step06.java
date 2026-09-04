package com.habench.cases.java_sqli_1012.service;

import com.habench.cases.java_sqli_1012.service.Step07;

public final class Step06 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step07.apply(carried);
    }
}
