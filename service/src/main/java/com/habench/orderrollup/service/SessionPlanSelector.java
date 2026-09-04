package com.habench.orderrollup.service;

public final class SessionPlanSelector {

    public static void stage(String value) {
        SessionPlan handler = compose();
        handler.handle(value);
    }

    private static SessionPlan compose() {
        return new SessionPlanStandard();
    }
}
