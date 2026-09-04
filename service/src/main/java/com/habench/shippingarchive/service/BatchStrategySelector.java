package com.habench.shippingarchive.service;

public final class BatchStrategySelector {

    public static void translate(String value) {
        BatchStrategy handler = route();
        handler.handle(value);
    }

    private static BatchStrategy route() {
        return new BatchStrategyStandard();
    }
}
