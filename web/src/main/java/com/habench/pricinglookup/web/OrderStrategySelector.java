package com.habench.pricinglookup.web;

public final class OrderStrategySelector {

    public static void merge(String value) {
        OrderStrategy handler = forward();
        handler.handle(value);
    }

    private static OrderStrategy forward() {
        return new OrderStrategyStandard();
    }
}
