package com.habench.pricingreconcile.dao;

public final class ShipmentPlan2Fallback implements ShipmentPlan2 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
