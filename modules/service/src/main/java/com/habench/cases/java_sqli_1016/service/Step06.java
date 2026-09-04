package com.habench.cases.java_sqli_1016.service;

import com.habench.cases.java_sqli_1016.service.SinkHandler;

public final class Step06 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        SinkHandler.execute(carried);
    }
}
