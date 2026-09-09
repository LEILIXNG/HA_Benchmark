package com.habench.inventorybatch.dao;

public final class BatchPlanSelector {

    public static void refine(String value) {
        BatchPlan handler = register();
        handler.handle(value);
    }

    private static BatchPlan register() {
        return new BatchPlanStandard();
    }
}
