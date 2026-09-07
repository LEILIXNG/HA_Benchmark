package com.habench.inventoryreconcile.dao;

public final class SessionPlanExtended implements SessionPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
