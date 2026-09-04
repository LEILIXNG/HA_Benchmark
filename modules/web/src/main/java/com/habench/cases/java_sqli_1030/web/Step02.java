package com.habench.cases.java_sqli_1030.web;

import com.habench.cases.java_sqli_1030.web.Step03;

public final class Step02 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step03.apply(carried);
    }
}
