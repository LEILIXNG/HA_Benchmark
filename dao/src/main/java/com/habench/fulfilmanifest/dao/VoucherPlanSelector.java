package com.habench.fulfilmanifest.dao;

public final class VoucherPlanSelector {

    public static void dispatch(String value) {
        VoucherPlan handler = route();
        handler.handle(value);
    }

    private static VoucherPlan route() {
        return new VoucherPlanStandard();
    }
}
