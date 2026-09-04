package com.habench.cases.java_sqli_1021_n.service;

import com.habench.cases.java_sqli_1021_n.service.Sanitizer02;

public final class Step01 {

    public static void apply(String value) {
        String carried = value;
        Sanitizer02.apply(carried);
    }
}
