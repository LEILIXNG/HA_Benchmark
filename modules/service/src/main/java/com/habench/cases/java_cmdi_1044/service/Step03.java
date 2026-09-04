package com.habench.cases.java_cmdi_1044.service;

import com.habench.cases.java_cmdi_1044.service.SinkHandler;

public final class Step03 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        SinkHandler.execute(carried);
    }
}
