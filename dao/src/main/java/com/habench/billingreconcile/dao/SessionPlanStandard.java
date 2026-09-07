package com.habench.billingreconcile.dao;

public final class SessionPlanStandard implements SessionPlan {
    @Override
    public void handle(String value) {
        QuoteTranslator.route(value);
    }
}
