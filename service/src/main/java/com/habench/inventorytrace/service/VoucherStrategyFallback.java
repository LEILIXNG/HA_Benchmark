package com.habench.inventorytrace.service;

public final class VoucherStrategyFallback implements VoucherStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
