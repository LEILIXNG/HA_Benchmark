package com.habench.cases.java_sqli_1003.web;

import com.habench.cases.java_sqli_1003.service.Gateway04;

public final class Step03 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Gateway04.apply(carried);
    }
}
