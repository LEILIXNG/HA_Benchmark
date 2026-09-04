package com.habench.paymentnotice.service;

public final class QuotePolicyStandard implements QuotePolicy {
    @Override
    public void handle(String value) {
        SessionNormalizer.stage(value);
    }
}
