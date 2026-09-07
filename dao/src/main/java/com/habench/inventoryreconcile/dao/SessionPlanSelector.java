package com.habench.inventoryreconcile.dao;

public final class SessionPlanSelector {

    public static void stage(String value) {
        SessionPlan handler = dispatch();
        handler.handle(value);
    }

    private static SessionPlan dispatch() {
        return new SessionPlanStandard();
    }
}
