package com.habench.fulfillookup.service;

public final class OrderStrategySelector {

    public static void collect(String value) {
        OrderStrategy handler = reconcile();
        handler.handle(value);
    }

    private static OrderStrategy reconcile() {
        return new OrderStrategyStandard();
    }
}
