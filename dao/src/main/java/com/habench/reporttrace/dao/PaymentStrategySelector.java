package com.habench.reporttrace.dao;

public final class PaymentStrategySelector {

    public static void collect(String value) {
        PaymentStrategy handler = publish();
        handler.handle(value);
    }

    private static PaymentStrategy publish() {
        return new PaymentStrategyStandard();
    }
}
