package com.habench.cases.java_sqli_1068.web;

import com.habench.cases.java_sqli_1068.service.Gateway02;

public final class Step01 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Gateway02.apply(carried);
    }
}
