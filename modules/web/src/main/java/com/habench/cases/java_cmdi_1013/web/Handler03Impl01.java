package com.habench.cases.java_cmdi_1013.web;

public final class Handler03Impl01 implements Handler03 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
