package com.habench.cases.java_path_1049.service;

public final class Handler08Impl03 implements Handler08 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
