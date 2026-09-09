package com.habench.pricingarchive.service;

public final class LedgerPolicyFallback implements LedgerPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
