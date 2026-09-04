package com.habench.cases.java_sqli_1030_n.web;

public final class Handler10Impl03 implements Handler10 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
