package com.habench.shippingdispatch.dao;

public final class BatchStrategySelector {

    public static void normalize(String value) {
        BatchStrategy handler = assemble();
        handler.handle(value);
    }

    private static BatchStrategy assemble() {
        return new BatchStrategyStandard();
    }
}
