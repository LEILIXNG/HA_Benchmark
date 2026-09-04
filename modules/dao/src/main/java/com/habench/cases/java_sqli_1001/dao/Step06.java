package com.habench.cases.java_sqli_1001.dao;

import com.habench.cases.java_sqli_1001.dao.Step07;

public final class Step06 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step07.apply(carried);
    }
}
