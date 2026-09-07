package com.habench.fulfilquote.service;

public final class QuotePlanSelector {

    public static void translate(String value) {
        QuotePlan handler = route();
        handler.handle(value);
    }

    private static QuotePlan route() {
        return new QuotePlanStandard();
    }
}
