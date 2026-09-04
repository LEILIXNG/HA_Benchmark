package com.habench.cmdi1044.service;

public final class Handler02Impl03 implements Handler02 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
