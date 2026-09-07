package com.habench.billingclose.web;

public final class ShipmentStrategySelector {

    public static void submit(String value) {
        ShipmentStrategy handler = collect();
        handler.handle(value);
    }

    private static ShipmentStrategy collect() {
        return new ShipmentStrategyStandard();
    }
}
