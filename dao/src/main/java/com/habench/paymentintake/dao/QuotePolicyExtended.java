package com.habench.paymentintake.dao;

public final class QuotePolicyExtended implements QuotePolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
