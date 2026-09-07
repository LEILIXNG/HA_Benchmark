package com.habench.pricingassign.service;

public final class QuoteRuleStandard implements QuoteRule {
    @Override
    public void handle(String value) {
        RefundCoordinator.normalize(value);
    }
}
