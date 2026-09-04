package com.habench.cmdi1020n.dao;

public final class Handler04Impl02 implements Handler04 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
