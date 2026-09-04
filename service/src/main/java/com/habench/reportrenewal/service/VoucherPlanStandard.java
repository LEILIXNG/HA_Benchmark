package com.habench.reportrenewal.service;

public final class VoucherPlanStandard implements VoucherPlan {
    @Override
    public void handle(String value) {
        OrderRouter.compose(value);
    }
}
