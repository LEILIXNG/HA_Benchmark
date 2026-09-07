package com.habench.inventorysubmit.web;

public final class PaymentPolicySelector {

    public static void collect(String value) {
        PaymentPolicy handler = prepare();
        handler.handle(value);
    }

    private static PaymentPolicy prepare() {
        return new PaymentPolicyStandard();
    }
}
