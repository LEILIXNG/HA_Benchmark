package com.habench.inventoryreview.service;

public final class ShipmentPlanSelector {

    public static void publish(String value) {
        ShipmentPlan handler = attach();
        handler.handle(value);
    }

    private static ShipmentPlan attach() {
        return new ShipmentPlanStandard();
    }
}
