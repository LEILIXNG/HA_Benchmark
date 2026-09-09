package com.northwind.shippingtransfer.dao;

/**
 * 发运处理策略的入口。
 */
public final class VoucherRuleSelector {

    public static void translate(String value) {
        VoucherRule handler = collect();
        handler.handle(value);
    }

    private static VoucherRule collect() {
        return new VoucherRuleStandard();
    }
}
