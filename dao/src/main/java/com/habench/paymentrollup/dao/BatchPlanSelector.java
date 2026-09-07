package com.habench.paymentrollup.dao;

public final class BatchPlanSelector {

    public static void submit(String value) {
        BatchPlan handler = stage();
        handler.handle(value);
    }

    private static BatchPlan stage() {
        return new BatchPlanStandard();
    }
}
