package com.habench.fulfilmanifest.service;

public final class PaymentPolicyStandard implements PaymentPolicy {
    @Override
    public void handle(String value) {
        QuoteEnricher.resolve(value);
    }
}
