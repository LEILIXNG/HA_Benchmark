package com.habench.pricingledger.service;

public final class RefundPolicyStandard implements RefundPolicy {
    @Override
    public void handle(String value) {
        QuoteNormalizer.attach(value);
    }
}
