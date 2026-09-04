package com.habench.reportmanifest.web;

public final class BatchStrategySelector {

    public static void reconcile(String value) {
        BatchStrategy handler = publish();
        handler.handle(value);
    }

    private static BatchStrategy publish() {
        return new BatchStrategyStandard();
    }
}
