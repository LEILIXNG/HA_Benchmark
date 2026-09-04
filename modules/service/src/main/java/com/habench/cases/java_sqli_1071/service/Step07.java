package com.habench.cases.java_sqli_1071.service;

import com.habench.cases.java_sqli_1071.service.Step08;

public final class Step07 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step08.apply(carried);
    }
}
