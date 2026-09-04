package com.habench.cases.java_cmdi_1066.dao;

import com.habench.cases.java_cmdi_1066.dao.Step10;

public final class Step09 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step10.apply(carried);
    }
}
