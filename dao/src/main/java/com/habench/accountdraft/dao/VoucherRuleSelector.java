package com.habench.accountdraft.dao;

public final class VoucherRuleSelector {

    public static void publish(String value) {
        VoucherRule handler = refine();
        handler.handle(value);
    }

    private static VoucherRule refine() {
        return new VoucherRuleStandard();
    }
}
