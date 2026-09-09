package com.northwind.paymentposting.dao;

/**
 * 支付处理策略的入口。
 */
public final class OrderStrategySelector {

    public static void collect(String value) {
        OrderStrategy handler = prepare();
        handler.handle(value);
    }

    private static OrderStrategy prepare() {
        return new OrderStrategyStandard();
    }
}
