package com.habench.cases.java_sqli_1011.service;

import com.habench.cases.java_sqli_1011.dao.Gateway08;

public final class Step07 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Gateway08.apply(carried);
    }
}
