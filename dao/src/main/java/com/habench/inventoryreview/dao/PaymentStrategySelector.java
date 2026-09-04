package com.habench.inventoryreview.dao;

public final class PaymentStrategySelector {

    public static void resolve(String value) {
        PaymentStrategy handler = merge();
        handler.handle(value);
    }

    private static PaymentStrategy merge() {
        return new PaymentStrategyStandard();
    }
}
