package com.habench.vendornotice.service;

public final class LedgerStrategyStandard implements LedgerStrategy {
    @Override
    public void handle(String value) {
        OrderResolver.submit(value);
    }
}
