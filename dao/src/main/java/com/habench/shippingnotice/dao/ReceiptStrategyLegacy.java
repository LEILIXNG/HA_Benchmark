package com.habench.shippingnotice.dao;

public final class ReceiptStrategyLegacy implements ReceiptStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
