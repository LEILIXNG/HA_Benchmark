package com.habench.customerarchive.service;

public final class PaymentStrategySelector {

    public static void route(String value) {
        PaymentStrategy handler = refine();
        handler.handle(value);
    }

    private static PaymentStrategy refine() {
        return new PaymentStrategyStandard();
    }
}
