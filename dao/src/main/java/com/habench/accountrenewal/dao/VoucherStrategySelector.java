package com.habench.accountrenewal.dao;

public final class VoucherStrategySelector {

    public static void assemble(String value) {
        VoucherStrategy handler = reconcile();
        handler.handle(value);
    }

    private static VoucherStrategy reconcile() {
        return new VoucherStrategyStandard();
    }
}
