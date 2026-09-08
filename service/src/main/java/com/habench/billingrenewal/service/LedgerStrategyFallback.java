package com.habench.billingrenewal.service;

public final class LedgerStrategyFallback implements LedgerStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
