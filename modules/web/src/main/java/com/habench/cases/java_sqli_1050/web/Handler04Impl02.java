package com.habench.cases.java_sqli_1050.web;

public final class Handler04Impl02 implements Handler04 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
