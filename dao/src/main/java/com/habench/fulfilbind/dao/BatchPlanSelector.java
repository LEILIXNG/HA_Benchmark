package com.habench.fulfilbind.dao;

public final class BatchPlanSelector {

    public static void reconcile(String value) {
        BatchPlan handler = stage();
        handler.handle(value);
    }

    private static BatchPlan stage() {
        return new BatchPlanStandard();
    }
}
