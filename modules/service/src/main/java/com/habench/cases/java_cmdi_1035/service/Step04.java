package com.habench.cases.java_cmdi_1035.service;

import com.habench.cases.java_cmdi_1035.dao.Gateway05;

public final class Step04 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Gateway05.apply(carried);
    }
}
