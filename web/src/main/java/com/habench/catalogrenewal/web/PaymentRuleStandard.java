package com.habench.catalogrenewal.web;

public final class PaymentRuleStandard implements PaymentRule {
    @Override
    public void handle(String value) {
        LedgerBroker.submit(value);
    }
}
