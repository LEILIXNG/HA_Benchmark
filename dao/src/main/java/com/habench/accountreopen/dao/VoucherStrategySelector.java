package com.habench.accountreopen.dao;

public final class VoucherStrategySelector {

    public static void collect(String value) {
        VoucherStrategy handler = resolve();
        handler.handle(value);
    }

    private static VoucherStrategy resolve() {
        return new VoucherStrategyStandard();
    }
}
