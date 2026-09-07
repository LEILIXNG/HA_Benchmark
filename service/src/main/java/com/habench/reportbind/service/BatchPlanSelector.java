package com.habench.reportbind.service;

public final class BatchPlanSelector {

    public static void normalize(String value) {
        BatchPlan handler = dispatch();
        handler.handle(value);
    }

    private static BatchPlan dispatch() {
        return new BatchPlanStandard();
    }
}
