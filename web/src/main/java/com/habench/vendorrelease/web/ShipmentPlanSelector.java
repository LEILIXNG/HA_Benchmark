package com.habench.vendorrelease.web;

public final class ShipmentPlanSelector {

    public static void translate(String value) {
        ShipmentPlan handler = resolve();
        handler.handle(value);
    }

    private static ShipmentPlan resolve() {
        return new ShipmentPlanStandard();
    }
}
