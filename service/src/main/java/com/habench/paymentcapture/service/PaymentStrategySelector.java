package com.habench.paymentcapture.service;

public final class PaymentStrategySelector {

    public static void compose(String value) {
        PaymentStrategy handler = resolve();
        handler.handle(value);
    }

    private static PaymentStrategy resolve() {
        return new PaymentStrategyStandard();
    }
}
