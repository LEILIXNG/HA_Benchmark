package com.habench.pricingrenewal.service;

public final class CatalogStrategyStandard implements CatalogStrategy {
    @Override
    public void handle(String value) {
        InvoiceBroker.prepare(value);
    }
}
