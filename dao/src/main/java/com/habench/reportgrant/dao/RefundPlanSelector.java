package com.habench.reportgrant.dao;

public final class RefundPlanSelector {

    public static void translate(String value) {
        RefundPlan handler = route();
        handler.handle(value);
    }

    private static RefundPlan route() {
        return new RefundPlanStandard();
    }
}
