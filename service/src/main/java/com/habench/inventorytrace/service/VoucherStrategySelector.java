package com.habench.inventorytrace.service;

public final class VoucherStrategySelector {

    public static void translate(String value) {
        VoucherStrategy handler = stage();
        handler.handle(value);
    }

    private static VoucherStrategy stage() {
        return new VoucherStrategyStandard();
    }
}
