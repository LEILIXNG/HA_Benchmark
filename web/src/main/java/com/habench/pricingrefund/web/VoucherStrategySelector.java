package com.habench.pricingrefund.web;

public final class VoucherStrategySelector {

    public static void stage(String value) {
        VoucherStrategy handler = forward();
        handler.handle(value);
    }

    private static VoucherStrategy forward() {
        return new VoucherStrategyStandard();
    }
}
