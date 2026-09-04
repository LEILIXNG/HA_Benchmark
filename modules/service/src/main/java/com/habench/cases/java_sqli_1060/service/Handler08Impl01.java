package com.habench.cases.java_sqli_1060.service;

public final class Handler08Impl01 implements Handler08 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
