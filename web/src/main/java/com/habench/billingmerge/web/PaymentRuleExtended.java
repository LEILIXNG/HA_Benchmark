package com.habench.billingmerge.web;

public final class PaymentRuleExtended implements PaymentRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
