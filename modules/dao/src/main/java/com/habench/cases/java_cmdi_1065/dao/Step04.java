package com.habench.cases.java_cmdi_1065.dao;

import com.habench.cases.java_cmdi_1065.dao.Sanitizer05;

public final class Step04 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Sanitizer05.apply(carried);
    }
}
