package com.habench.cases.java_cmdi_1066_n.web;

import com.habench.cases.java_cmdi_1066_n.service.Gateway06;

public final class Step05 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Gateway06.apply(carried);
    }
}
