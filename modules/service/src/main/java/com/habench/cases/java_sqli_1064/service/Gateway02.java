package com.habench.cases.java_sqli_1064.service;

import com.habench.cases.java_sqli_1064.service.SinkHandler;

public final class Gateway02 {

    public static void apply(String value) {
        SinkHandler.execute(value);
    }
}
