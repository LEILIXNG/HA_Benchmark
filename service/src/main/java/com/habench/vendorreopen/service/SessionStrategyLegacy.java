package com.habench.vendorreopen.service;

public final class SessionStrategyLegacy implements SessionStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
