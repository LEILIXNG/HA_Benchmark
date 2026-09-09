package com.habench.fulfilexport.web;

public final class QuotePlanSelector {

    public static void expand(String value) {
        QuotePlan handler = forward();
        handler.handle(value);
    }

    private static QuotePlan forward() {
        return new QuotePlanStandard();
    }
}
