package com.habench.cases.java_path_1028.service;

public final class Handler05Impl01 implements Handler05 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
