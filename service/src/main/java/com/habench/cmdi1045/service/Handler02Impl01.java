package com.habench.cmdi1045.service;

public final class Handler02Impl01 implements Handler02 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
