package com.habench.cases.java_path_1016.web;

public final class Handler06Impl03 implements Handler06 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
