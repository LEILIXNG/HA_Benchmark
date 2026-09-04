package com.habench.cases.java_sqli_1019.service;

import com.habench.cases.java_sqli_1019.service.Step04;

public final class Step03 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step04.apply(carried);
    }
}
