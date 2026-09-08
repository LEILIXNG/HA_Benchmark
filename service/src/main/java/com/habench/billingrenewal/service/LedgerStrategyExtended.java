package com.habench.billingrenewal.service;

public final class LedgerStrategyExtended implements LedgerStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
