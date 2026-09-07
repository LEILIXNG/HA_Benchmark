package com.habench.catalogsplit.web;

public final class SessionPlanSelector {

    public static void submit(String value) {
        SessionPlan handler = prepare();
        handler.handle(value);
    }

    private static SessionPlan prepare() {
        return new SessionPlanStandard();
    }
}
