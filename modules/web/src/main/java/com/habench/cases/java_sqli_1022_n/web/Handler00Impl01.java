package com.habench.cases.java_sqli_1022_n.web;

public final class Handler00Impl01 implements Handler00 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
