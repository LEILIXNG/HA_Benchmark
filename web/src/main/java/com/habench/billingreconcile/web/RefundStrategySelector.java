package com.habench.billingreconcile.web;

public final class RefundStrategySelector {

    public static void publish(String value) {
        RefundStrategy handler = forward();
        handler.handle(value);
    }

    private static RefundStrategy forward() {
        return new RefundStrategyStandard();
    }
}
