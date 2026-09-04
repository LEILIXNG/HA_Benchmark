package com.habench.vendorquote.web;

public final class ShipmentPlanSelector {

    public static void register(String value) {
        ShipmentPlan handler = assemble();
        handler.handle(value);
    }

    private static ShipmentPlan assemble() {
        return new ShipmentPlanStandard();
    }
}
