package com.habench.cases.java_cmdi_1036.web;

import com.habench.cases.java_cmdi_1036.web.SinkHandler;

public final class Handler00Impl00 implements Handler00 {
    @Override
    public void handle(String value) {
        SinkHandler.execute(value);
    }
}
