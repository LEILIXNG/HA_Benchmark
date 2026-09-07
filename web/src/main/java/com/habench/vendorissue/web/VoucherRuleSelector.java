package com.habench.vendorissue.web;

public final class VoucherRuleSelector {

    public static void register(String value) {
        VoucherRule handler = assemble();
        handler.handle(value);
    }

    private static VoucherRule assemble() {
        return new VoucherRuleStandard();
    }
}
