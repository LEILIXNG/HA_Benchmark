package com.habench.billingreconcile.dao;

public final class SessionPlanSelector {

    public static void forward(String value) {
        SessionPlan handler = translate();
        handler.handle(value);
    }

    private static SessionPlan translate() {
        return new SessionPlanStandard();
    }
}
