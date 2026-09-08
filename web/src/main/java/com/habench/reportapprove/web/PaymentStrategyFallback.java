package com.habench.reportapprove.web;

public final class PaymentStrategyFallback implements PaymentStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
