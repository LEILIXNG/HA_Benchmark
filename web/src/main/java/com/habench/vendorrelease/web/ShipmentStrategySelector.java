package com.habench.vendorrelease.web;

public final class ShipmentStrategySelector {

    public static void attach(String value) {
        ShipmentStrategy handler = prepare();
        handler.handle(value);
    }

    private static ShipmentStrategy prepare() {
        return new ShipmentStrategyStandard();
    }
}
