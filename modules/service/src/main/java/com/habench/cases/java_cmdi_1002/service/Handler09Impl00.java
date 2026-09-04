package com.habench.cases.java_cmdi_1002.service;

import com.habench.cases.java_cmdi_1002.dao.Gateway10;

public final class Handler09Impl00 implements Handler09 {
    @Override
    public void handle(String value) {
        Gateway10.apply(value);
    }
}
