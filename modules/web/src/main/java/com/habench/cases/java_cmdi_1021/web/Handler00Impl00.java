package com.habench.cases.java_cmdi_1021.web;

import com.habench.cases.java_cmdi_1021.service.Gateway01;

public final class Handler00Impl00 implements Handler00 {
    @Override
    public void handle(String value) {
        Gateway01.apply(value);
    }
}
