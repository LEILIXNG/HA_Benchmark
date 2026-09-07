package com.habench.vendorgrant.dao;

public final class RefundPolicyStandard implements RefundPolicy {
    @Override
    public void handle(String value) {
        QuoteNormalizer.resolve(value);
    }
}
