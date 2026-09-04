package com.habench.cases.java_cmdi_1032.service;

import com.habench.cases.java_cmdi_1032.service.SinkHandler;

public final class Handler09Impl00 implements Handler09 {
    @Override
    public void handle(String value) {
        SinkHandler.execute(value);
    }
}
