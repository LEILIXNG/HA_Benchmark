package com.habench.cases.java_sqli_1028.service;

import com.habench.cases.java_sqli_1028.dao.Gateway06;

public final class Step05 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Gateway06.apply(carried);
    }
}
