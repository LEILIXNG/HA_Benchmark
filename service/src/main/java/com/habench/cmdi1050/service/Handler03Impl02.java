package com.habench.cmdi1050.service;

public final class Handler03Impl02 implements Handler03 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
