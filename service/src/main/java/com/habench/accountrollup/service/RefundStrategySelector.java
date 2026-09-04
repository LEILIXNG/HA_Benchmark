package com.habench.accountrollup.service;

public final class RefundStrategySelector {

    public static void compose(String value) {
        RefundStrategy handler = collect();
        handler.handle(value);
    }

    private static RefundStrategy collect() {
        return new RefundStrategyStandard();
    }
}
