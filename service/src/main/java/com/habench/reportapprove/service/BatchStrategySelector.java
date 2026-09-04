package com.habench.reportapprove.service;

public final class BatchStrategySelector {

    public static void dispatch(String value) {
        BatchStrategy handler = register();
        handler.handle(value);
    }

    private static BatchStrategy register() {
        return new BatchStrategyStandard();
    }
}
