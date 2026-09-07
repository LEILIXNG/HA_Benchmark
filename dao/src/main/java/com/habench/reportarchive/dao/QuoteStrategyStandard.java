package com.habench.reportarchive.dao;

public final class QuoteStrategyStandard implements QuoteStrategy {
    @Override
    public void handle(String value) {
        TariffCollector.enrich(value);
    }
}
