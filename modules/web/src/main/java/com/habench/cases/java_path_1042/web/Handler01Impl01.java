package com.habench.cases.java_path_1042.web;

public final class Handler01Impl01 implements Handler01 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
