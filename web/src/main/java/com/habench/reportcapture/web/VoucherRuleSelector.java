package com.habench.reportcapture.web;

public final class VoucherRuleSelector {

    public static void collect(String value) {
        VoucherRule handler = dispatch();
        handler.handle(value);
    }

    private static VoucherRule dispatch() {
        return new VoucherRuleStandard();
    }
}
