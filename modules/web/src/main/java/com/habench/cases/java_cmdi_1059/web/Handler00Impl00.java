package com.habench.cases.java_cmdi_1059.web;

import com.habench.cases.java_cmdi_1059.service.Gateway01;

public final class Handler00Impl00 implements Handler00 {
    @Override
    public void handle(String value) {
        Gateway01.apply(value);
    }
}
