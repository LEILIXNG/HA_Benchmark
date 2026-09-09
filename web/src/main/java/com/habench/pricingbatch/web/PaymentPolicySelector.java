package com.habench.pricingbatch.web;

public final class PaymentPolicySelector {

    public static void prepare(String value) {
        PaymentPolicy handler = forward();
        handler.handle(value);
    }

    private static PaymentPolicy forward() {
        return new PaymentPolicyStandard();
    }
}
