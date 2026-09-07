package com.habench.paymentsplit.web;

public final class VoucherRuleSelector {

    public static void translate(String value) {
        VoucherRule handler = assemble();
        handler.handle(value);
    }

    private static VoucherRule assemble() {
        return new VoucherRuleStandard();
    }
}
