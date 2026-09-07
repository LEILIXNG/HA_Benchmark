package com.habench.accountverify.dao;

public final class PaymentPlanFallback implements PaymentPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
