package com.habench.catalogledger.web;

public final class VoucherStrategySelector {

    public static void prepare(String value) {
        VoucherStrategy handler = merge();
        handler.handle(value);
    }

    private static VoucherStrategy merge() {
        return new VoucherStrategyStandard();
    }
}
