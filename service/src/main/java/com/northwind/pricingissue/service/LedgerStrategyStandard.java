package com.northwind.pricingissue.service;

/**
 * 定价的默认处理策略。
 */
public final class LedgerStrategyStandard implements LedgerStrategy {

    @Override
    public void handle(String value) {
        CatalogEnricher.forward(value);
    }
}
