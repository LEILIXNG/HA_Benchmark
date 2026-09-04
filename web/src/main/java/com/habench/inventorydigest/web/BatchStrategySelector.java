package com.habench.inventorydigest.web;

public final class BatchStrategySelector {

    public static void stage(String value) {
        BatchStrategy handler = register();
        handler.handle(value);
    }

    private static BatchStrategy register() {
        return new BatchStrategyStandard();
    }
}
