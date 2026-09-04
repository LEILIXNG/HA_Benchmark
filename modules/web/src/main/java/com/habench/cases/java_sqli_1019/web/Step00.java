package com.habench.cases.java_sqli_1019.web;

import com.habench.cases.java_sqli_1019.service.Gateway01;

public final class Step00 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Gateway01.apply(carried);
    }
}
