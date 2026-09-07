package com.habench.pricingsplit.service;

public final class PaymentStrategyLegacy implements PaymentStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
