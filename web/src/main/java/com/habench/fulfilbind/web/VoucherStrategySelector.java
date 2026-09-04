package com.habench.fulfilbind.web;

public final class VoucherStrategySelector {

    public static void merge(String value) {
        VoucherStrategy handler = expand();
        handler.handle(value);
    }

    private static VoucherStrategy expand() {
        return new VoucherStrategyStandard();
    }
}
