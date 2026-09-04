package com.habench.accountsplit.web;

public final class QuoteStrategyStandard implements QuoteStrategy {
    @Override
    public void handle(String value) {
        OrderRegistry.collect(value);
    }
}
