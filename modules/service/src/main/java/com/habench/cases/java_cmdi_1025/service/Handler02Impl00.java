package com.habench.cases.java_cmdi_1025.service;

import com.habench.cases.java_cmdi_1025.service.Step03;

public final class Handler02Impl00 implements Handler02 {
    @Override
    public void handle(String value) {
        Step03.apply(value);
    }
}
