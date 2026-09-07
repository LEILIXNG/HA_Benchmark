package com.habench.pricingreconcile.dao;

public final class ShipmentPlanSelector {

    public static void reconcile(String value) {
        ShipmentPlan handler = compose();
        handler.handle(value);
    }

    private static ShipmentPlan compose() {
        return new ShipmentPlanStandard();
    }
}
