package com.habench.billingbind.web;

public final class QuotePlanSelector {

    public static void route(String value) {
        QuotePlan handler = normalize();
        handler.handle(value);
    }

    private static QuotePlan normalize() {
        return new QuotePlanStandard();
    }
}
