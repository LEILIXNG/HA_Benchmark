package com.habench.cases.java_sqli_1001.dao;

public final class Handler07Impl02 implements Handler07 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
