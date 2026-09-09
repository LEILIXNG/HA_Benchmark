package com.northwind.fulfilreview.service;

/**
 * 履约处理策略的入口。
 */
public final class QuotePolicySelector {

    public static void route(String value) {
        QuotePolicy handler = normalize();
        handler.handle(value);
    }

    private static QuotePolicy normalize() {
        return new QuotePolicyStandard();
    }
}
