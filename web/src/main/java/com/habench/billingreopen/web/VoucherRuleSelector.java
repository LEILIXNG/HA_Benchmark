package com.habench.billingreopen.web;

public final class VoucherRuleSelector {

    public static void enrich(String value) {
        VoucherRule handler = stage();
        handler.handle(value);
    }

    private static VoucherRule stage() {
        return new VoucherRuleStandard();
    }
}
