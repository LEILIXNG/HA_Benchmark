package com.habench.ordersubmit.dao;

public final class PaymentPlanSelector {

    public static void dispatch(String value) {
        PaymentPlan handler = enrich();
        handler.handle(value);
    }

    private static PaymentPlan enrich() {
        return new PaymentPlanStandard();
    }
}
