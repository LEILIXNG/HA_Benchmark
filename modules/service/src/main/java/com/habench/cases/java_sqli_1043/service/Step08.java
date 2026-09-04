package com.habench.cases.java_sqli_1043.service;

import com.habench.cases.java_sqli_1043.service.SinkHandler;

public final class Step08 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        SinkHandler.execute(carried);
    }
}
