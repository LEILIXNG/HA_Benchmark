package com.habench.pricingsplit.service;

public final class PaymentStrategySelector {

    public static void collect(String value) {
        PaymentStrategy handler = forward();
        handler.handle(value);
    }

    private static PaymentStrategy forward() {
        return new PaymentStrategyStandard();
    }
}
