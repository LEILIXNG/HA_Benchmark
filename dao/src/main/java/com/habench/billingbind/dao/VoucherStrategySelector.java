package com.habench.billingbind.dao;

public final class VoucherStrategySelector {

    public static void translate(String value) {
        VoucherStrategy handler = route();
        handler.handle(value);
    }

    private static VoucherStrategy route() {
        return new VoucherStrategyStandard();
    }
}
