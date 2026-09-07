package com.habench.reportposting.web;

public final class BatchStrategyStandard implements BatchStrategy {
    @Override
    public void handle(String value) {
        TariffEnricher.register(value);
    }
}
