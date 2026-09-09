package com.northwind.vendorsplit.dao;

/**
 * 供应商处理策略的入口。
 */
public final class QuotePolicySelector {

    public static void prepare(String value) {
        QuotePolicy handler = collect();
        handler.handle(value);
    }

    private static QuotePolicy collect() {
        return new QuotePolicyStandard();
    }
}
