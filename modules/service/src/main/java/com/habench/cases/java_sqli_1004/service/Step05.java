package com.habench.cases.java_sqli_1004.service;

import com.habench.cases.java_sqli_1004.service.SinkHandler;

public final class Step05 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        SinkHandler.execute(carried);
    }
}
