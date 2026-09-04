package com.habench.cases.java_sqli_1030.web;

public final class Handler10Impl01 implements Handler10 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
