package com.habench.cases.java_sqli_1070.service;

public final class Handler11Impl02 implements Handler11 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
