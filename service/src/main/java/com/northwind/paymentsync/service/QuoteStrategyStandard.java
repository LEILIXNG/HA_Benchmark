package com.northwind.paymentsync.service;

/**
 * 支付的默认处理策略。
 */
public final class QuoteStrategyStandard implements QuoteStrategy {

    @Override
    public void handle(String value) {
        OrderRegistry.collect(value);
    }
}
