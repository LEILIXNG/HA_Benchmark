package com.habench.billinghold.service;

public final class PaymentPlanStandard implements PaymentPlan {
    @Override
    public void handle(String value) {
        ManifestService.collect(value);
    }
}
