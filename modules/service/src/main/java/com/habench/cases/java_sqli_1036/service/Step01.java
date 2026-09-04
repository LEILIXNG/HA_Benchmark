package com.habench.cases.java_sqli_1036.service;

import com.habench.cases.java_sqli_1036.service.SinkHandler;

public final class Step01 {

    public static void apply(String value) {
        String carried = value;
        SinkHandler.execute(carried);
    }
}
