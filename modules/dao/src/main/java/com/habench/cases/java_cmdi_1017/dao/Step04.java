package com.habench.cases.java_cmdi_1017.dao;

import com.habench.cases.java_cmdi_1017.dao.Step05;

public final class Step04 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step05.apply(carried);
    }
}
