package com.habench.billingtrace.dao;

public final class OrderStrategySelector {

    public static void refine(String value) {
        OrderStrategy handler = translate();
        handler.handle(value);
    }

    private static OrderStrategy translate() {
        return new OrderStrategyStandard();
    }
}
