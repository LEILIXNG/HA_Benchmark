package com.habench.cases.java_cmdi_1005.service;

import com.habench.cases.java_cmdi_1005.service.SinkHandler;

public final class Handler05Impl00 implements Handler05 {
    @Override
    public void handle(String value) {
        SinkHandler.execute(value);
    }
}
