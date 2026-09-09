package com.habench.catalogdispatch.web;

public final class BatchStrategySelector {

    public static void submit(String value) {
        BatchStrategy handler = reconcile();
        handler.handle(value);
    }

    private static BatchStrategy reconcile() {
        return new BatchStrategyStandard();
    }
}
