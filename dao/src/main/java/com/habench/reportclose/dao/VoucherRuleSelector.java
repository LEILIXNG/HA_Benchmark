package com.habench.reportclose.dao;

public final class VoucherRuleSelector {

    public static void publish(String value) {
        VoucherRule handler = assemble();
        handler.handle(value);
    }

    private static VoucherRule assemble() {
        return new VoucherRuleStandard();
    }
}
