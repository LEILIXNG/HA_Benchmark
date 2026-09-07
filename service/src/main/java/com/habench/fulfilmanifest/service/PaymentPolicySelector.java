package com.habench.fulfilmanifest.service;

public final class PaymentPolicySelector {

    public static void refine(String value) {
        PaymentPolicy handler = expand();
        handler.handle(value);
    }

    private static PaymentPolicy expand() {
        return new PaymentPolicyStandard();
    }
}
