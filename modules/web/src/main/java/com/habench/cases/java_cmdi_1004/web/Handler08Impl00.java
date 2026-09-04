package com.habench.cases.java_cmdi_1004.web;

import com.habench.cases.java_cmdi_1004.service.Gateway09;

public final class Handler08Impl00 implements Handler08 {
    @Override
    public void handle(String value) {
        Gateway09.apply(value);
    }
}
