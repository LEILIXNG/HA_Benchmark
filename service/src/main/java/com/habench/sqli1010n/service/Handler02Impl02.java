package com.habench.sqli1010n.service;

public final class Handler02Impl02 implements Handler02 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
