package com.habench.inventorydispatch.web;

public final class QuotePlanSelector {

    public static void register(String value) {
        QuotePlan handler = dispatch();
        handler.handle(value);
    }

    private static QuotePlan dispatch() {
        return new QuotePlanStandard();
    }
}
