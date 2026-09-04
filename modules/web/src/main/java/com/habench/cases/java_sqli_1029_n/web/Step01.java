package com.habench.cases.java_sqli_1029_n.web;

import com.habench.cases.java_sqli_1029_n.web.Sanitizer02;

public final class Step01 {

    public static void apply(String value) {
        String carried = value;
        Sanitizer02.apply(carried);
    }
}
