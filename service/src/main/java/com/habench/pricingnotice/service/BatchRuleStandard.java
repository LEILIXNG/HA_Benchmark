package com.habench.pricingnotice.service;

public final class BatchRuleStandard implements BatchRule {
    @Override
    public void handle(String value) {
        PaymentBroker.reconcile(value);
    }
}
