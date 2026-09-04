package com.habench.cases.java_cmdi_1003.service;

import com.habench.cases.java_cmdi_1003.service.SinkHandler;

public final class Step10 {

    public static void apply(String value) {
        String carried = value;
        SinkHandler.execute(carried);
    }
}
