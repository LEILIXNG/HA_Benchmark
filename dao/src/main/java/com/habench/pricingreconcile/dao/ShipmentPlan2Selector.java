package com.habench.pricingreconcile.dao;

public final class ShipmentPlan2Selector {

    public static void submit(String value) {
        ShipmentPlan2 handler = compose();
        handler.handle(value);
    }

    private static ShipmentPlan2 compose() {
        return new ShipmentPlan2Standard();
    }
}
