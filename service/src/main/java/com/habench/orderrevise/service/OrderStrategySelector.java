package com.habench.orderrevise.service;

public final class OrderStrategySelector {

    public static void resolve(String value) {
        OrderStrategy handler = publish();
        handler.handle(value);
    }

    private static OrderStrategy publish() {
        return new OrderStrategyStandard();
    }
}
