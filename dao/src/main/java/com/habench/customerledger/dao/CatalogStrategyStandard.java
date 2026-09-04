package com.habench.customerledger.dao;

public final class CatalogStrategyStandard implements CatalogStrategy {
    @Override
    public void handle(String value) {
        ReceiptEnricher.forward(value);
    }
}
