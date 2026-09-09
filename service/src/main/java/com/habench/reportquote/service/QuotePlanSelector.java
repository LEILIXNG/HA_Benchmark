package com.habench.reportquote.service;

public final class QuotePlanSelector {

    public static void compose(String value) {
        QuotePlan handler = merge();
        handler.handle(value);
    }

    private static QuotePlan merge() {
        return new QuotePlanStandard();
    }
}
