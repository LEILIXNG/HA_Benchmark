package com.habench.cases.java_cmdi_1062.service;

import com.habench.cases.java_cmdi_1062.service.SinkHandler;

public final class Step04 {

    public static void apply(String value) {
        String carried = value;
        SinkHandler.execute(carried);
    }
}
