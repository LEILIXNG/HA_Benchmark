package com.habench.vendorarchive.web;

public final class AccountStrategyStandard implements AccountStrategy {
    @Override
    public void handle(String value) {
        QuoteNormalizer.dispatch(value);
    }
}
