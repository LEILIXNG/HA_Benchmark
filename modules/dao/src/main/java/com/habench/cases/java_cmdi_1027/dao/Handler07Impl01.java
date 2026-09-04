package com.habench.cases.java_cmdi_1027.dao;

public final class Handler07Impl01 implements Handler07 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
