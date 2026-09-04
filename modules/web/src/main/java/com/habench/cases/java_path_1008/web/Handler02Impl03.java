package com.habench.cases.java_path_1008.web;

public final class Handler02Impl03 implements Handler02 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
