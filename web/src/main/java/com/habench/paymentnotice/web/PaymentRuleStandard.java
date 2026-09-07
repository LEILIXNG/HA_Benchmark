package com.habench.paymentnotice.web;

public final class PaymentRuleStandard implements PaymentRule {
    @Override
    public void handle(String value) {
        ReceiptEnricher.dispatch(value);
    }
}
