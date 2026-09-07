package com.habench.fulfilrelease.web;

public final class PaymentPolicySelector {

    public static void collect(String value) {
        PaymentPolicy handler = publish();
        handler.handle(value);
    }

    private static PaymentPolicy publish() {
        return new PaymentPolicyStandard();
    }
}
