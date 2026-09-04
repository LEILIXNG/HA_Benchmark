package com.habench.cases.java_sqli_1029_n.web;

import com.habench.cases.java_sqli_1029_n.web.Step01;

public final class Step00 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step01.apply(carried);
    }
}
