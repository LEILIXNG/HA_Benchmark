package com.habench.vendorrelease.service;

public final class PaymentPlanStandard implements PaymentPlan {
    @Override
    public void handle(String value) {
        PaymentRegistry.translate(value);
    }
}
