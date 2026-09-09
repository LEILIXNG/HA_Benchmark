package com.habench.reportissue.web;

public final class QuotePlanSelector {

    public static void merge(String value) {
        QuotePlan handler = prepare();
        handler.handle(value);
    }

    private static QuotePlan prepare() {
        return new QuotePlanStandard();
    }
}
