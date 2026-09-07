package com.habench.ordersubmit.dao;

public final class PaymentPlanStandard implements PaymentPlan {
    @Override
    public void handle(String value) {
        SessionBuilder.enrich(value);
    }
}
