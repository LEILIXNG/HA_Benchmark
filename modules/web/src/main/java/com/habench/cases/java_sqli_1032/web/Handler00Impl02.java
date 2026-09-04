package com.habench.cases.java_sqli_1032.web;

public final class Handler00Impl02 implements Handler00 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
