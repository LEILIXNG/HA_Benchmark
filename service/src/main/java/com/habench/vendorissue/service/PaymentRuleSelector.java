package com.habench.vendorissue.service;

public final class PaymentRuleSelector {

    public static void enrich(String value) {
        PaymentRule handler = attach();
        handler.handle(value);
    }

    private static PaymentRule attach() {
        return new PaymentRuleStandard();
    }
}
