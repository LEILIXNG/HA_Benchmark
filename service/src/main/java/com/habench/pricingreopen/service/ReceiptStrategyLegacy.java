package com.habench.pricingreopen.service;

public final class ReceiptStrategyLegacy implements ReceiptStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
