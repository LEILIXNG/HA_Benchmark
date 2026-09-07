package com.habench.paymentadjust.web;

public final class PaymentPolicySelector {

    public static void expand(String value) {
        PaymentPolicy handler = collect();
        handler.handle(value);
    }

    private static PaymentPolicy collect() {
        return new PaymentPolicyStandard();
    }
}
