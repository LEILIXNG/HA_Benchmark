package com.habench.cases.java_sqli_1070.service;

import com.habench.cases.java_sqli_1070.service.SinkHandler;

public final class Handler11Impl00 implements Handler11 {
    @Override
    public void handle(String value) {
        SinkHandler.execute(value);
    }
}
