package com.habench.inventoryreview.dao;

public final class PaymentStrategyLegacy implements PaymentStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
