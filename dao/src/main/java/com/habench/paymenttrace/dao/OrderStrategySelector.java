package com.habench.paymenttrace.dao;

public final class OrderStrategySelector {

    public static void stage(String value) {
        OrderStrategy handler = merge();
        handler.handle(value);
    }

    private static OrderStrategy merge() {
        return new OrderStrategyStandard();
    }
}
