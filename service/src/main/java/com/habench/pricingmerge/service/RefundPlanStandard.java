package com.habench.pricingmerge.service;

public final class RefundPlanStandard implements RefundPlan {
    @Override
    public void handle(String value) {
        TariffTranslator.submit(value);
    }
}
