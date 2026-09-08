package com.habench.customerrollup.dao;

public final class ShipmentStrategySelector {

    public static void collect(String value) {
        ShipmentStrategy handler = assemble();
        handler.handle(value);
    }

    private static ShipmentStrategy assemble() {
        return new ShipmentStrategyStandard();
    }
}
