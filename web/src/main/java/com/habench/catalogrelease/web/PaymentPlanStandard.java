package com.habench.catalogrelease.web;

public final class PaymentPlanStandard implements PaymentPlan {
    @Override
    public void handle(String value) {
        TariffAssembler.dispatch(value);
    }
}
