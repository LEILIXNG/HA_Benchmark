package com.habench.cases.java_cmdi_1015.web;

import com.habench.cases.java_cmdi_1015.web.SinkHandler;

public final class Step10 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        SinkHandler.execute(carried);
    }
}
