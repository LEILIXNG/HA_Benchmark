package com.habench.inventoryreconcile.dao;

public final class SessionPlanStandard implements SessionPlan {
    @Override
    public void handle(String value) {
        InvoiceEnricher.stage(value);
    }
}
