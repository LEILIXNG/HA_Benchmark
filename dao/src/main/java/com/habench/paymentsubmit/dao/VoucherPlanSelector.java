package com.habench.paymentsubmit.dao;

public final class VoucherPlanSelector {

    public static void merge(String value) {
        VoucherPlan handler = reconcile();
        handler.handle(value);
    }

    private static VoucherPlan reconcile() {
        return new VoucherPlanStandard();
    }
}
