package com.northwind.reportarchive.dao;

/**
 * 报表的默认处理策略。
 */
public final class QuoteStrategyStandard implements QuoteStrategy {

    @Override
    public void handle(String value) {
        TariffCollector.enrich(value);
    }
}
