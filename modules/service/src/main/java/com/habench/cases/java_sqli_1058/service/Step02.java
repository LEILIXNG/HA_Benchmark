package com.habench.cases.java_sqli_1058.service;

import com.habench.cases.java_sqli_1058.service.Step03;

public final class Step02 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step03.apply(carried);
    }
}
