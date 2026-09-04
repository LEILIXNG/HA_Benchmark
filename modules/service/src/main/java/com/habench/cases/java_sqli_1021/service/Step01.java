package com.habench.cases.java_sqli_1021.service;

import com.habench.cases.java_sqli_1021.service.SinkHandler;

public final class Step01 {

    public static void apply(String value) {
        String carried = value;
        SinkHandler.execute(carried);
    }
}
