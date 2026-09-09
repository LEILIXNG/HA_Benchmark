package com.habench.pricingnotice.service;

public final class QuotePlanSelector {

    public static void refine(String value) {
        QuotePlan handler = resolve();
        handler.handle(value);
    }

    private static QuotePlan resolve() {
        return new QuotePlanStandard();
    }
}
