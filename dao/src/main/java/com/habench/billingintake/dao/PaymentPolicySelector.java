package com.habench.billingintake.dao;

public final class PaymentPolicySelector {

    public static void expand(String value) {
        PaymentPolicy handler = translate();
        handler.handle(value);
    }

    private static PaymentPolicy translate() {
        return new PaymentPolicyStandard();
    }
}
