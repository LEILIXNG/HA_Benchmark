package com.habench.billinghold.service;

public final class PaymentPlanSelector {

    public static void assemble(String value) {
        PaymentPlan handler = normalize();
        handler.handle(value);
    }

    private static PaymentPlan normalize() {
        return new PaymentPlanStandard();
    }
}
