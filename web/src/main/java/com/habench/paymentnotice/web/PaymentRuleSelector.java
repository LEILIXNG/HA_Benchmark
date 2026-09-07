package com.habench.paymentnotice.web;

public final class PaymentRuleSelector {

    public static void publish(String value) {
        PaymentRule handler = stage();
        handler.handle(value);
    }

    private static PaymentRule stage() {
        return new PaymentRuleStandard();
    }
}
