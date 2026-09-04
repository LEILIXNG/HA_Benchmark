package com.habench.cases.java_sqli_1058.service;

public final class Handler04Impl03 implements Handler04 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
