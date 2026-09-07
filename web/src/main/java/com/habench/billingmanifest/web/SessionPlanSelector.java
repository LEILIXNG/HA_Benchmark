package com.habench.billingmanifest.web;

public final class SessionPlanSelector {

    public static void attach(String value) {
        SessionPlan handler = normalize();
        handler.handle(value);
    }

    private static SessionPlan normalize() {
        return new SessionPlanStandard();
    }
}
