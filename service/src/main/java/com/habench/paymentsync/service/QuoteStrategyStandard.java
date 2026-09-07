package com.habench.paymentsync.service;

public final class QuoteStrategyStandard implements QuoteStrategy {
    @Override
    public void handle(String value) {
        OrderRegistry.collect(value);
    }
}
