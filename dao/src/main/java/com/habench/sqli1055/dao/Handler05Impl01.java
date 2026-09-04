package com.habench.sqli1055.dao;

public final class Handler05Impl01 implements Handler05 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
