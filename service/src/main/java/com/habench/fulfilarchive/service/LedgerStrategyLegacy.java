package com.habench.fulfilarchive.service;

public final class LedgerStrategyLegacy implements LedgerStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
