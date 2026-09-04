package com.habench.cases.java_cmdi_1027_n.web;

import com.habench.cases.java_cmdi_1027_n.service.Gateway02;

public final class Step01 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Gateway02.apply(carried);
    }
}
