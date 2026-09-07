package com.habench.customerdispatch.service;

public final class QuotePlanSelector {

    public static void stage(String value) {
        QuotePlan handler = translate();
        handler.handle(value);
    }

    private static QuotePlan translate() {
        return new QuotePlanStandard();
    }
}
