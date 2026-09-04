package com.habench.cases.java_cmdi_1008.service;

import com.habench.cases.java_cmdi_1008.dao.Gateway05;

public final class Handler04Impl00 implements Handler04 {
    @Override
    public void handle(String value) {
        Gateway05.apply(value);
    }
}
