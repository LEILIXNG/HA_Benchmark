package com.habench.cases.java_sqli_1058_n.service;

import com.habench.cases.java_sqli_1058_n.service.Step09;

public final class Step08 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step09.apply(carried);
    }
}
