package com.habench.inventorydraft.web;

public final class CatalogPlanStandard implements CatalogPlan {
    @Override
    public void handle(String value) {
        PaymentResolver.refine(value);
    }
}
