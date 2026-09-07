package com.habench.billingmerge.web;

public final class PaymentRuleSelector {

    public static void compose(String value) {
        PaymentRule handler = collect();
        handler.handle(value);
    }

    private static PaymentRule collect() {
        return new PaymentRuleStandard();
    }
}
