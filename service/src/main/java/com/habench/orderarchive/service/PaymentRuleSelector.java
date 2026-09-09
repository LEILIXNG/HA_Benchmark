package com.habench.orderarchive.service;

public final class PaymentRuleSelector {

    public static void attach(String value) {
        PaymentRule handler = resolve();
        handler.handle(value);
    }

    private static PaymentRule resolve() {
        return new PaymentRuleStandard();
    }
}
