package com.habench.catalogrelease.web;

public final class PaymentPlanSelector {

    public static void forward(String value) {
        PaymentPlan handler = expand();
        handler.handle(value);
    }

    private static PaymentPlan expand() {
        return new PaymentPlanStandard();
    }
}
