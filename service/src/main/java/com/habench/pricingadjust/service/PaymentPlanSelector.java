package com.habench.pricingadjust.service;

public final class PaymentPlanSelector {

    public static void normalize(String value) {
        PaymentPlan handler = reconcile();
        handler.handle(value);
    }

    private static PaymentPlan reconcile() {
        return new PaymentPlanStandard();
    }
}
