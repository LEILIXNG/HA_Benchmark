package com.habench.cases.java_sqli_1003.service;

import com.habench.cases.java_sqli_1003.service.SinkHandler;

public final class Handler07Impl00 implements Handler07 {
    @Override
    public void handle(String value) {
        SinkHandler.execute(value);
    }
}
