package com.habench.accountverify.web;

public final class PaymentPlanSelector {

    public static void dispatch(String value) {
        PaymentPlan handler = register();
        handler.handle(value);
    }

    private static PaymentPlan register() {
        return new PaymentPlanStandard();
    }
}
