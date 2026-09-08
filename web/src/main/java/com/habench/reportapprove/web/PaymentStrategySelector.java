package com.habench.reportapprove.web;

public final class PaymentStrategySelector {

    public static void prepare(String value) {
        PaymentStrategy handler = assemble();
        handler.handle(value);
    }

    private static PaymentStrategy assemble() {
        return new PaymentStrategyStandard();
    }
}
