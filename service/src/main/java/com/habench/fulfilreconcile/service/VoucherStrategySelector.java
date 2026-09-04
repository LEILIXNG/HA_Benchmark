package com.habench.fulfilreconcile.service;

public final class VoucherStrategySelector {

    public static void compose(String value) {
        VoucherStrategy handler = stage();
        handler.handle(value);
    }

    private static VoucherStrategy stage() {
        return new VoucherStrategyStandard();
    }
}
