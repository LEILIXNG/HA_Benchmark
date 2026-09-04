package com.habench.cases.java_cmdi_1025.service;

public final class Handler06Impl01 implements Handler06 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
