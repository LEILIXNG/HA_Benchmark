package com.habench.cases.java_sqli_1051.service;

import com.habench.cases.java_sqli_1051.dao.Gateway03;

public final class Step02 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Gateway03.apply(carried);
    }
}
