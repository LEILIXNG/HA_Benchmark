package com.habench.shippingtransfer.dao;

public final class VoucherRuleSelector {

    public static void translate(String value) {
        VoucherRule handler = collect();
        handler.handle(value);
    }

    private static VoucherRule collect() {
        return new VoucherRuleStandard();
    }
}
