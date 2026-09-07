package com.habench.paymentreconcile.web;

public final class TariffPlanStandard implements TariffPlan {
    @Override
    public void handle(String value) {
        RefundCoordinator.forward(value);
    }
}
