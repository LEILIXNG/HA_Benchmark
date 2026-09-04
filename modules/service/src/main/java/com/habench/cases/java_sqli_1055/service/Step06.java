package com.habench.cases.java_sqli_1055.service;

import com.habench.cases.java_sqli_1055.dao.Gateway07;

public final class Step06 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Gateway07.apply(carried);
    }
}
