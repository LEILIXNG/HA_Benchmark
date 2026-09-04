package com.habench.fulfilissue.web;

public final class VoucherStrategySelector {

    public static void publish(String value) {
        VoucherStrategy handler = attach();
        handler.handle(value);
    }

    private static VoucherStrategy attach() {
        return new VoucherStrategyStandard();
    }
}
