package com.habench.inventorydigest.web;

public final class BatchStrategyStandard implements BatchStrategy {
    @Override
    public void handle(String value) {
        TariffEnricher.enrich(value);
    }
}
