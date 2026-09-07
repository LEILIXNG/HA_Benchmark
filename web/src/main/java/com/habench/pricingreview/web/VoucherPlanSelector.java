package com.habench.pricingreview.web;

public final class VoucherPlanSelector {

    public static void route(String value) {
        VoucherPlan handler = refine();
        handler.handle(value);
    }

    private static VoucherPlan refine() {
        return new VoucherPlanStandard();
    }
}
