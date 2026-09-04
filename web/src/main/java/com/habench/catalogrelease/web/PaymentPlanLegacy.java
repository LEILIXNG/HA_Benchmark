package com.habench.catalogrelease.web;

public final class PaymentPlanLegacy implements PaymentPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
