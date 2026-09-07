package com.habench.paymentrenewal.web;

public final class QuotePlanSelector {

    public static void collect(String value) {
        QuotePlan handler = publish();
        handler.handle(value);
    }

    private static QuotePlan publish() {
        return new QuotePlanStandard();
    }
}
