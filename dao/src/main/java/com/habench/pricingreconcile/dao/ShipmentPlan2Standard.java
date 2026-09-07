package com.habench.pricingreconcile.dao;

public final class ShipmentPlan2Standard implements ShipmentPlan2 {
    @Override
    public void handle(String value) {
        AccountRegistry.assemble(value);
    }
}
