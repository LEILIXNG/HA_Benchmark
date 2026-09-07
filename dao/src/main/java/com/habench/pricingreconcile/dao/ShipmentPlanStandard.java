package com.habench.pricingreconcile.dao;

public final class ShipmentPlanStandard implements ShipmentPlan {
    @Override
    public void handle(String value) {
        RefundCollector.register(value);
    }
}
