package com.habench.shippingverify.web;

public final class VoucherRuleSelector {

    public static void assemble(String value) {
        VoucherRule handler = dispatch();
        handler.handle(value);
    }

    private static VoucherRule dispatch() {
        return new VoucherRuleStandard();
    }
}
