package com.habench.vendoradjust.web;

public final class QuotePlanSelector {

    public static void reconcile(String value) {
        QuotePlan handler = translate();
        handler.handle(value);
    }

    private static QuotePlan translate() {
        return new QuotePlanStandard();
    }
}
