package com.habench.cases.java_sqli_1026.service;

import com.habench.cases.java_sqli_1026.service.SinkHandler;

public final class Step03 {

    public static void apply(String value) {
        String carried = value;
        SinkHandler.execute(carried);
    }
}
