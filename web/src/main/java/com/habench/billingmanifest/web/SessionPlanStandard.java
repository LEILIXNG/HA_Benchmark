package com.habench.billingmanifest.web;

public final class SessionPlanStandard implements SessionPlan {
    @Override
    public void handle(String value) {
        ReceiptCoordinator.assemble(value);
    }
}
