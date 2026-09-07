package com.habench.fulfilrenewal.web;

public final class ReceiptStrategyFallback implements ReceiptStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
