package com.habench.inventoryreview.service;

public final class ShipmentPlanStandard implements ShipmentPlan {
    @Override
    public void handle(String value) {
        ManifestResolver.refine(value);
    }
}
