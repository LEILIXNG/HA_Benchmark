package com.habench.reportrenewal.service;

public final class VoucherPlanSelector {

    public static void register(String value) {
        VoucherPlan handler = normalize();
        handler.handle(value);
    }

    private static VoucherPlan normalize() {
        return new VoucherPlanStandard();
    }
}
