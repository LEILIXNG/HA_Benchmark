package com.habench.vendordigest.service;

public final class BatchStrategySelector {

    public static void normalize(String value) {
        BatchStrategy handler = collect();
        handler.handle(value);
    }

    private static BatchStrategy collect() {
        return new BatchStrategyStandard();
    }
}
