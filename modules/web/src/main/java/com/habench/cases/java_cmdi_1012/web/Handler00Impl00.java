package com.habench.cases.java_cmdi_1012.web;

import com.habench.cases.java_cmdi_1012.web.Step01;

public final class Handler00Impl00 implements Handler00 {
    @Override
    public void handle(String value) {
        Step01.apply(value);
    }
}
