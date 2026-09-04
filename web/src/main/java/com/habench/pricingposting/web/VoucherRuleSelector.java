package com.habench.pricingposting.web;

public final class VoucherRuleSelector {

    public static void normalize(String value) {
        VoucherRule handler = compose();
        handler.handle(value);
    }

    private static VoucherRule compose() {
        return new VoucherRuleStandard();
    }
}
