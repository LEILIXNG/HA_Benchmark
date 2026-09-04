package com.habench.sqli1040n.web;

public final class Handler03Impl03 implements Handler03 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
