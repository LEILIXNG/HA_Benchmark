package com.habench.billingmerge.web;

public final class PaymentRuleStandard implements PaymentRule {
    @Override
    public void handle(String value) {
        AccountAssembler.normalize(value);
    }
}
