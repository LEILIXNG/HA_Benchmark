package com.habench.cases.java_cmdi_1025.service;

import com.habench.cases.java_cmdi_1025.dao.Gateway07;

public final class Handler06Impl00 implements Handler06 {
    @Override
    public void handle(String value) {
        Gateway07.apply(value);
    }
}
