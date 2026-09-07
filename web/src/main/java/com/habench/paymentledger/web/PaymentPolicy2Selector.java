package com.habench.paymentledger.web;

public final class PaymentPolicy2Selector {

    public static void register(String value) {
        PaymentPolicy2 handler = enrich();
        handler.handle(value);
    }

    private static PaymentPolicy2 enrich() {
        return new PaymentPolicy2Standard();
    }
}
