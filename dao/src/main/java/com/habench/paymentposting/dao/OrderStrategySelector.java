package com.habench.paymentposting.dao;

public final class OrderStrategySelector {

    public static void collect(String value) {
        OrderStrategy handler = prepare();
        handler.handle(value);
    }

    private static OrderStrategy prepare() {
        return new OrderStrategyStandard();
    }
}
