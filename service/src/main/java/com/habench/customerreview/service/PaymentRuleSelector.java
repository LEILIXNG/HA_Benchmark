package com.habench.customerreview.service;

public final class PaymentRuleSelector {

    public static void translate(String value) {
        PaymentRule handler = route();
        handler.handle(value);
    }

    private static PaymentRule route() {
        return new PaymentRuleStandard();
    }
}
