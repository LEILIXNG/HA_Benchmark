package com.habench.inventoryposting.service;

public final class ShipmentPlanSelector {

    public static void compose(String value) {
        ShipmentPlan handler = publish();
        handler.handle(value);
    }

    private static ShipmentPlan publish() {
        return new ShipmentPlanStandard();
    }
}
