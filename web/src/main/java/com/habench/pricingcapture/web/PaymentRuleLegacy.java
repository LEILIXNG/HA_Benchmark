package com.habench.pricingcapture.web;

public final class PaymentRuleLegacy implements PaymentRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
