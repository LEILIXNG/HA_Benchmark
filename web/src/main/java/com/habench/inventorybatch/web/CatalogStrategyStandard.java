package com.habench.inventorybatch.web;

public final class CatalogStrategyStandard implements CatalogStrategy {
    @Override
    public void handle(String value) {
        TariffAdapter.stage(value);
    }
}
