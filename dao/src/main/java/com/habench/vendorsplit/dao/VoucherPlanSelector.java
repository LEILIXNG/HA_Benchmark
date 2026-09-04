package com.habench.vendorsplit.dao;

public final class VoucherPlanSelector {

    public static void assemble(String value) {
        VoucherPlan handler = collect();
        handler.handle(value);
    }

    private static VoucherPlan collect() {
        return new VoucherPlanStandard();
    }
}
