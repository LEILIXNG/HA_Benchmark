package com.habench.cases.java_sqli_1037.service;

import com.habench.cases.java_sqli_1037.service.SinkHandler;

public final class Step03Delegate {

    static void handle(String value) {
        SinkHandler.execute(value);
    }
}
