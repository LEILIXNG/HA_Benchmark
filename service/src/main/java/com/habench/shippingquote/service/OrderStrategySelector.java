package com.habench.shippingquote.service;

public final class OrderStrategySelector {

    public static void forward(String value) {
        OrderStrategy handler = enrich();
        handler.handle(value);
    }

    private static OrderStrategy enrich() {
        return new OrderStrategyStandard();
    }
}
