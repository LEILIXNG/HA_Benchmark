package com.habench.orderlookup.web;

public final class PaymentRuleFallback implements PaymentRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
