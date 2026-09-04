package com.habench.billingapprove.service;

public final class SessionPlanStandard implements SessionPlan {
    @Override
    public void handle(String value) {
        InvoiceAssembler.stage(value);
    }
}
