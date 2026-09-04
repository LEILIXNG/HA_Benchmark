package com.habench.inventorymerge.service;

public final class OrderStrategySelector {

    public static void route(String value) {
        OrderStrategy handler = register();
        handler.handle(value);
    }

    private static OrderStrategy register() {
        return new OrderStrategyStandard();
    }
}
