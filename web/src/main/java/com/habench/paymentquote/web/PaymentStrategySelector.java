package com.habench.paymentquote.web;

public final class PaymentStrategySelector {

    public static void merge(String value) {
        PaymentStrategy handler = route();
        handler.handle(value);
    }

    private static PaymentStrategy route() {
        return new PaymentStrategyStandard();
    }
}
