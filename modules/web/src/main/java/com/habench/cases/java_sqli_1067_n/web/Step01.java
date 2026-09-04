package com.habench.cases.java_sqli_1067_n.web;

import com.habench.cases.java_sqli_1067_n.web.Step02;

public final class Step01 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step02.apply(carried);
    }
}
