package com.habench.sqli1056n.service;

public final class Handler05Impl02 implements Handler05 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
