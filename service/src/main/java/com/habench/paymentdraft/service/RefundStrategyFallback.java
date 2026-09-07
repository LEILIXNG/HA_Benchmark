package com.habench.paymentdraft.service;

public final class RefundStrategyFallback implements RefundStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
