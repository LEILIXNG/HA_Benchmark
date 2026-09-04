package com.habench.paymentimport.service;

public final class CatalogStrategyStandard implements CatalogStrategy {
    @Override
    public void handle(String value) {
        BatchTranslator.compose(value);
    }
}
