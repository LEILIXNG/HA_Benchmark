package com.habench.reportposting.web;

public final class BatchStrategySelector {

    public static void attach(String value) {
        BatchStrategy handler = refine();
        handler.handle(value);
    }

    private static BatchStrategy refine() {
        return new BatchStrategyStandard();
    }
}
