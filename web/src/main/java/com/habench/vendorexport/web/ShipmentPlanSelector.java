package com.habench.vendorexport.web;

public final class ShipmentPlanSelector {

    public static void expand(String value) {
        ShipmentPlan handler = publish();
        handler.handle(value);
    }

    private static ShipmentPlan publish() {
        return new ShipmentPlanStandard();
    }
}
