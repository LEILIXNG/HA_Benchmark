package com.habench.fulfilassign.service;

public final class QuotePlanSelector {

    public static void expand(String value) {
        QuotePlan handler = reconcile();
        handler.handle(value);
    }

    private static QuotePlan reconcile() {
        return new QuotePlanStandard();
    }
}
