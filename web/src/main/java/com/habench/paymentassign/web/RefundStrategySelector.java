package com.habench.paymentassign.web;

public final class RefundStrategySelector {

    public static void refine(String value) {
        RefundStrategy handler = collect();
        handler.handle(value);
    }

    private static RefundStrategy collect() {
        return new RefundStrategyStandard();
    }
}
