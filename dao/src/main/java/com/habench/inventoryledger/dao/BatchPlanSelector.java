package com.habench.inventoryledger.dao;

public final class BatchPlanSelector {

    public static void enrich(String value) {
        BatchPlan handler = prepare();
        handler.handle(value);
    }

    private static BatchPlan prepare() {
        return new BatchPlanStandard();
    }
}
