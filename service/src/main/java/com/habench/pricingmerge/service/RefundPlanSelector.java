package com.habench.pricingmerge.service;

public final class RefundPlanSelector {

    public static void compose(String value) {
        RefundPlan handler = attach();
        handler.handle(value);
    }

    private static RefundPlan attach() {
        return new RefundPlanStandard();
    }
}
