package com.habench.billingrevise.web;

public final class CatalogPlanStandard implements CatalogPlan {
    @Override
    public void handle(String value) {
        ShipmentEnricher.forward(value);
    }
}
