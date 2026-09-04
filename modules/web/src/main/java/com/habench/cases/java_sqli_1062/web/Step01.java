package com.habench.cases.java_sqli_1062.web;

import com.habench.cases.java_sqli_1062.web.Step02;

public final class Step01 {

    public static void apply(String value) {
        String carried = value;
        Step02.apply(carried);
    }
}
