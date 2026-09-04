package com.habench.cases.java_cmdi_1027_n.dao;

import com.habench.cases.java_cmdi_1027_n.dao.Sanitizer09;

public final class Step08 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Sanitizer09.apply(carried);
    }
}
