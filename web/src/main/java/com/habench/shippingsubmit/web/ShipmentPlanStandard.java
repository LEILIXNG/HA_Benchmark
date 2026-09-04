package com.habench.shippingsubmit.web;

public final class ShipmentPlanStandard implements ShipmentPlan {
    @Override
    public void handle(String value) {
        ManifestResolver.forward(value);
    }
}
