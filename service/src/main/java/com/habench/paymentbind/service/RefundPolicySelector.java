package com.habench.paymentbind.service;

public final class RefundPolicySelector {

    public static void submit(String value) {
        RefundPolicy handler = register();
        handler.handle(value);
    }

    private static RefundPolicy register() {
        return new RefundPolicyStandard();
    }
}
