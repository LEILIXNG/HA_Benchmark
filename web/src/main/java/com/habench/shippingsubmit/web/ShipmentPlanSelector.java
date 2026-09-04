package com.habench.shippingsubmit.web;

public final class ShipmentPlanSelector {

    public static void dispatch(String value) {
        ShipmentPlan handler = route();
        handler.handle(value);
    }

    private static ShipmentPlan route() {
        return new ShipmentPlanStandard();
    }
}
