package com.habench.pricingissue.service;

public final class LedgerStrategyStandard implements LedgerStrategy {
    @Override
    public void handle(String value) {
        CatalogEnricher.forward(value);
    }
}
