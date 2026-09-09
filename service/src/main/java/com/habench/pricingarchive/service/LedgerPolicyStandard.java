package com.habench.pricingarchive.service;

public final class LedgerPolicyStandard implements LedgerPolicy {
    @Override
    public void handle(String value) {
        SessionNormalizer.merge(value);
    }
}
