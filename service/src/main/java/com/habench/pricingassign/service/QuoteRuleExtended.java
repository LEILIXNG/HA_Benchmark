package com.habench.pricingassign.service;

public final class QuoteRuleExtended implements QuoteRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
