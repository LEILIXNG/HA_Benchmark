package com.habench.accountsplit.web;

public final class QuoteStrategyFallback implements QuoteStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
