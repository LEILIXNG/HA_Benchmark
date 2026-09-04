package com.habench.cases.java_cmdi_1060.dao;

import com.habench.cases.java_cmdi_1060.dao.SinkHandler;

public final class Handler09Impl00 implements Handler09 {
    @Override
    public void handle(String value) {
        SinkHandler.execute(value);
    }
}
