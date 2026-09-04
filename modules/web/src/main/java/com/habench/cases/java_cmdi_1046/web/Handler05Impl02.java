package com.habench.cases.java_cmdi_1046.web;

public final class Handler05Impl02 implements Handler05 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
