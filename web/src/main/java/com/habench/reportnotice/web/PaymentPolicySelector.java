package com.habench.reportnotice.web;

public final class PaymentPolicySelector {

    public static void dispatch(String value) {
        PaymentPolicy handler = normalize();
        handler.handle(value);
    }

    private static PaymentPolicy normalize() {
        return new PaymentPolicyStandard();
    }
}
