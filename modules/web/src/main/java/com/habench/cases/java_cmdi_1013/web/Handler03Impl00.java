package com.habench.cases.java_cmdi_1013.web;

import com.habench.cases.java_cmdi_1013.web.SinkHandler;

public final class Handler03Impl00 implements Handler03 {
    @Override
    public void handle(String value) {
        SinkHandler.execute(value);
    }
}
