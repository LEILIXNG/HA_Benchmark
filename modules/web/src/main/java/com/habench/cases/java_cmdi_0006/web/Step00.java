package com.habench.cases.java_cmdi_0006.web;

import com.habench.cases.java_cmdi_0006.web.SinkHandler;

public final class Step00 {

    public static void apply(String value) {
        String carried = value;
        SinkHandler.execute(carried);
    }
}
