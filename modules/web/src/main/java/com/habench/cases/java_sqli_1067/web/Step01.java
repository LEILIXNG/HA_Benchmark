package com.habench.cases.java_sqli_1067.web;

import com.habench.cases.java_sqli_1067.web.Step02;

public final class Step01 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step02.apply(carried);
    }
}
