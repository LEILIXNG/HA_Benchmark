package com.habench.cases.java_cmdi_1037.web;

public final class Handler06Impl02 implements Handler06 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
