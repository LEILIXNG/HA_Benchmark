package com.habench.vendorrevise.web;

public final class ShipmentPlanStandard implements ShipmentPlan {
    @Override
    public void handle(String value) {
        BatchBroker.forward(value);
    }
}
