package com.habench.shippingdigest.dao;

public final class PaymentPolicySelector {

    public static void register(String value) {
        PaymentPolicy handler = merge();
        handler.handle(value);
    }

    private static PaymentPolicy merge() {
        return new PaymentPolicyStandard();
    }
}
