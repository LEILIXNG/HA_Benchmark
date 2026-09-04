package com.habench.cases.java_sqli_1015.service;

public final class Handler11Impl01 implements Handler11 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
