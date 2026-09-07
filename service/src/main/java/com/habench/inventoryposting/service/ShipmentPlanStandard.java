package com.habench.inventoryposting.service;

public final class ShipmentPlanStandard implements ShipmentPlan {
    @Override
    public void handle(String value) {
        OrderAdapter.merge(value);
    }
}
