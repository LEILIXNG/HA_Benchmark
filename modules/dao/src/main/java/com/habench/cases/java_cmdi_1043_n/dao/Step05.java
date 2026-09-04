package com.habench.cases.java_cmdi_1043_n.dao;

import com.habench.cases.java_cmdi_1043_n.dao.Sanitizer06;

public final class Step05 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Sanitizer06.apply(carried);
    }
}
