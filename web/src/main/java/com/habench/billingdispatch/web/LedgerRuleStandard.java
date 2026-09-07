package com.habench.billingdispatch.web;

public final class LedgerRuleStandard implements LedgerRule {
    @Override
    public void handle(String value) {
        PaymentAssembler.merge(value);
    }
}
