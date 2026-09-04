package com.habench.catalogreconcile.service;

public final class OrderStrategySelector {

    public static void compose(String value) {
        OrderStrategy handler = submit();
        handler.handle(value);
    }

    private static OrderStrategy submit() {
        return new OrderStrategyStandard();
    }
}
