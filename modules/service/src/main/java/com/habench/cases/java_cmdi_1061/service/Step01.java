package com.habench.cases.java_cmdi_1061.service;

import com.habench.cases.java_cmdi_1061.service.SinkHandler;

public final class Step01 {

    public static void apply(String value) {
        String carried = value;
        SinkHandler.execute(carried);
    }
}
