package com.habench.vendorsync.web;

public final class SessionStrategyFallback implements SessionStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
