package com.habench.shippingbatch.web;

public final class ShipmentPlanLegacy implements ShipmentPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
