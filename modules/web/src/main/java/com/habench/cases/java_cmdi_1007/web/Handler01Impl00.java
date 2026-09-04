package com.habench.cases.java_cmdi_1007.web;

import com.habench.cases.java_cmdi_1007.service.Gateway02;

public final class Handler01Impl00 implements Handler01 {
    @Override
    public void handle(String value) {
        Gateway02.apply(value);
    }
}
