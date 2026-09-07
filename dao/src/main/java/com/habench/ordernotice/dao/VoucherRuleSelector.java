package com.habench.ordernotice.dao;

public final class VoucherRuleSelector {

    public static void attach(String value) {
        VoucherRule handler = forward();
        handler.handle(value);
    }

    private static VoucherRule forward() {
        return new VoucherRuleStandard();
    }
}
