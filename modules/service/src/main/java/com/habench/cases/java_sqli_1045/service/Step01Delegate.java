package com.habench.cases.java_sqli_1045.service;

import com.habench.cases.java_sqli_1045.service.SinkHandler;

public final class Step01Delegate {

    static void handle(String value) {
        SinkHandler.execute(value);
    }
}
