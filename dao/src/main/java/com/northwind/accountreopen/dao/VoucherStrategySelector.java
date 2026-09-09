package com.northwind.accountreopen.dao;

/**
 * 账户处理策略的入口。
 */
public final class VoucherStrategySelector {

    public static void collect(String value) {
        VoucherStrategy handler = resolve();
        handler.handle(value);
    }

    private static VoucherStrategy resolve() {
        return new VoucherStrategyStandard();
    }
}
