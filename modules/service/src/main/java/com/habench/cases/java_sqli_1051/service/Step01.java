package com.habench.cases.java_sqli_1051.service;

import com.habench.cases.java_sqli_1051.service.Step02;

public final class Step01 {

    public static void apply(String value) {
        String carried = value;
        Step02.apply(carried);
    }
}
