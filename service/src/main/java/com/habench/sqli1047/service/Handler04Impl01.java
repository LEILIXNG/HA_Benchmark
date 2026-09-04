package com.habench.sqli1047.service;

public final class Handler04Impl01 implements Handler04 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
