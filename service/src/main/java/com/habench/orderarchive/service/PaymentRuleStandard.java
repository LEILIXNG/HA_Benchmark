package com.habench.orderarchive.service;

public final class PaymentRuleStandard implements PaymentRule {
    @Override
    public void handle(String value) {
        RefundService.publish(value);
    }
}
