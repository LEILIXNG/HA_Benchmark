package com.northwind.paymentexport.service;

/**
 * 支付处理策略的入口。
 */
public final class QuoteStrategySelector {

    public static void assemble(String value) {
        QuoteStrategy handler = prepare();
        handler.handle(value);
    }

    private static QuoteStrategy prepare() {
        return new QuoteStrategyStandard();
    }
}
