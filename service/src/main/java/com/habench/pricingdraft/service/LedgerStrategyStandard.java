package com.habench.pricingdraft.service;

public final class LedgerStrategyStandard implements LedgerStrategy {
    @Override
    public void handle(String value) {
        TariffBroker.collect(value);
    }
}
