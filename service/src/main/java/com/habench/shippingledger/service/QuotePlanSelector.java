package com.habench.shippingledger.service;

public final class QuotePlanSelector {

    public static void forward(String value) {
        QuotePlan handler = register();
        handler.handle(value);
    }

    private static QuotePlan register() {
        return new QuotePlanStandard();
    }
}
