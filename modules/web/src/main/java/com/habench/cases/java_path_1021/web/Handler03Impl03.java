package com.habench.cases.java_path_1021.web;

public final class Handler03Impl03 implements Handler03 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
