package com.habench.cases.java_cmdi_1009.web;

import com.habench.cases.java_cmdi_1009.web.Step01;

public final class Handler00Impl00 implements Handler00 {
    @Override
    public void handle(String value) {
        Step01.apply(value);
    }
}
