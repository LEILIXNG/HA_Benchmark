package com.habench.cases.java_cmdi_1067_n.dao;

import com.habench.cases.java_cmdi_1067_n.dao.Sanitizer08;

public final class Step07 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Sanitizer08.apply(carried);
    }
}
