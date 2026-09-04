package com.habench.fulfilarchive.service;

public final class LedgerStrategyStandard implements LedgerStrategy {
    @Override
    public void handle(String value) {
        OrderFacade.prepare(value);
    }
}
