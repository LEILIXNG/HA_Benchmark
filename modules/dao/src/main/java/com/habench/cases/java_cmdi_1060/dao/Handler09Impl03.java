package com.habench.cases.java_cmdi_1060.dao;

public final class Handler09Impl03 implements Handler09 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
