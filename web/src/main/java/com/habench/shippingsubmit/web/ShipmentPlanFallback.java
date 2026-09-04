package com.habench.shippingsubmit.web;

public final class ShipmentPlanFallback implements ShipmentPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
