package com.habench.ordersubmit.dao;

public final class PaymentPlanExtended implements PaymentPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
