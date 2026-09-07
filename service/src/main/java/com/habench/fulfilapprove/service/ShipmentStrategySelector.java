package com.habench.fulfilapprove.service;

public final class ShipmentStrategySelector {

    public static void forward(String value) {
        ShipmentStrategy handler = prepare();
        handler.handle(value);
    }

    private static ShipmentStrategy prepare() {
        return new ShipmentStrategyStandard();
    }
}
