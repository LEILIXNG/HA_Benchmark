package com.habench.cases.java_cmdi_1022_n.web;

public final class Handler02Impl01 implements Handler02 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
