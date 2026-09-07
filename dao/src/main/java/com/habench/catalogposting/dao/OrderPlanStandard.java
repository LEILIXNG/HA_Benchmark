package com.habench.catalogposting.dao;

public final class OrderPlanStandard implements OrderPlan {
    @Override
    public void handle(String value) {
        QuoteCoordinator.route(value);
    }
}
