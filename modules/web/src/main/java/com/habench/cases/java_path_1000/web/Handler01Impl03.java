package com.habench.cases.java_path_1000.web;

public final class Handler01Impl03 implements Handler01 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
