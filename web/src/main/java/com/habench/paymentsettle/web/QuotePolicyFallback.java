package com.habench.paymentsettle.web;

public final class QuotePolicyFallback implements QuotePolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
