package com.habench.catalogrenewal.web;

public final class PaymentRuleSelector {

    public static void reconcile(String value) {
        PaymentRule handler = prepare();
        handler.handle(value);
    }

    private static PaymentRule prepare() {
        return new PaymentRuleStandard();
    }
}
