package com.habench.vendorrelease.web;

public final class ShipmentPlanStandard implements ShipmentPlan {
    @Override
    public void handle(String value) {
        SessionBroker.collect(value);
    }
}
