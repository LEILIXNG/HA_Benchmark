package com.habench.paymentdraft.service;

public final class RefundStrategySelector {

    public static void collect(String value) {
        RefundStrategy handler = merge();
        handler.handle(value);
    }

    private static RefundStrategy merge() {
        return new RefundStrategyStandard();
    }
}
