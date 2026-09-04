package com.habench.cases.java_sqli_1012.service;

import com.habench.cases.java_sqli_1012.service.SinkHandler;

public final class Step07 {

    public static void apply(String value) {
        String carried = value;
        SinkHandler.execute(carried);
    }
}
