package com.habench.customerreview.service;

public final class PaymentRuleStandard implements PaymentRule {
    @Override
    public void handle(String value) {
        RefundComposer.collect(value);
    }
}
