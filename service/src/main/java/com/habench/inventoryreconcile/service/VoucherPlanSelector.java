package com.habench.inventoryreconcile.service;

public final class VoucherPlanSelector {

    public static void dispatch(String value) {
        VoucherPlan handler = forward();
        handler.handle(value);
    }

    private static VoucherPlan forward() {
        return new VoucherPlanStandard();
    }
}
