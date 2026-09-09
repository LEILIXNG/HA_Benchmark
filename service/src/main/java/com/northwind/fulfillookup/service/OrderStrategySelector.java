package com.northwind.fulfillookup.service;

/**
 * 履约处理策略的入口。
 */
public final class OrderStrategySelector {

    public static void collect(String value) {
        OrderStrategy handler = reconcile();
        handler.handle(value);
    }

    private static OrderStrategy reconcile() {
        return new OrderStrategyStandard();
    }
}
