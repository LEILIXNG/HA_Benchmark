package com.habench.cases.java_cmdi_1018.service;

public final class Handler04Impl01 implements Handler04 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
