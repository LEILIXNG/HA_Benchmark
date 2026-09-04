package com.habench.billingapprove.service;

public final class SessionPlanSelector {

    public static void refine(String value) {
        SessionPlan handler = normalize();
        handler.handle(value);
    }

    private static SessionPlan normalize() {
        return new SessionPlanStandard();
    }
}
