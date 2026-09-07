package com.habench.catalogposting.dao;

public final class OrderPlanLegacy implements OrderPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
