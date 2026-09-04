package com.habench.pricingadjust.service;

public final class PaymentPlanStandard implements PaymentPlan {
    @Override
    public void handle(String value) {
        ManifestAdapter.assemble(value);
    }
}
