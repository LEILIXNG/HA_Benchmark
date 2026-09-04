package com.habench.cases.java_cmdi_1027_n.dao;

public final class Handler07Impl03 implements Handler07 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
