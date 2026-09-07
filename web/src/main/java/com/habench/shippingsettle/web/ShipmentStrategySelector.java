package com.habench.shippingsettle.web;

public final class ShipmentStrategySelector {

    public static void route(String value) {
        ShipmentStrategy handler = submit();
        handler.handle(value);
    }

    private static ShipmentStrategy submit() {
        return new ShipmentStrategyStandard();
    }
}
