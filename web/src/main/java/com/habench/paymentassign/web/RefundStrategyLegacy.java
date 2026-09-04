package com.habench.paymentassign.web;

public final class RefundStrategyLegacy implements RefundStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
