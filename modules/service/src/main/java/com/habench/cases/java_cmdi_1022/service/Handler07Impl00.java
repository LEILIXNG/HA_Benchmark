package com.habench.cases.java_cmdi_1022.service;

import com.habench.cases.java_cmdi_1022.service.SinkHandler;

public final class Handler07Impl00 implements Handler07 {
    @Override
    public void handle(String value) {
        SinkHandler.execute(value);
    }
}
