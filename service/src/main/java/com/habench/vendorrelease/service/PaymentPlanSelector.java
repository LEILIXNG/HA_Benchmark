package com.habench.vendorrelease.service;

public final class PaymentPlanSelector {

    public static void enrich(String value) {
        PaymentPlan handler = forward();
        handler.handle(value);
    }

    private static PaymentPlan forward() {
        return new PaymentPlanStandard();
    }
}
