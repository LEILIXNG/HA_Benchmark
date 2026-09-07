package com.habench.shippingbind.service;

public final class VoucherStrategySelector {

    public static void stage(String value) {
        VoucherStrategy handler = route();
        handler.handle(value);
    }

    private static VoucherStrategy route() {
        return new VoucherStrategyStandard();
    }
}
