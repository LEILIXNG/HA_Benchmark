package com.habench.reportsync.service;

public final class QuotePlanSelector {

    public static void expand(String value) {
        QuotePlan handler = assemble();
        handler.handle(value);
    }

    private static QuotePlan assemble() {
        return new QuotePlanStandard();
    }
}
