package com.habench.pricingmerge.web;

public final class ShipmentStrategySelector {

    public static void attach(String value) {
        ShipmentStrategy handler = translate();
        handler.handle(value);
    }

    private static ShipmentStrategy translate() {
        return new ShipmentStrategyStandard();
    }
}
