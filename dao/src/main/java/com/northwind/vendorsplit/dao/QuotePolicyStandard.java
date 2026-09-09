package com.northwind.vendorsplit.dao;

/**
 * 供应商的默认处理策略。
 */
public final class QuotePolicyStandard implements QuotePolicy {

    @Override
    public void handle(String value) {
        OrderTranslator.dispatch(value);
    }
}
