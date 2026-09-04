package com.habench.cases.java_sqli_1025.web;

import com.habench.cases.java_sqli_1025.service.Gateway06;

public final class Step05 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Gateway06.apply(carried);
    }
}
