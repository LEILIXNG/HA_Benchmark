package com.habench.customerexport.service;

public final class ShipmentStrategySelector {

    public static void route(String value) {
        ShipmentStrategy handler = dispatch();
        handler.handle(value);
    }

    private static ShipmentStrategy dispatch() {
        return new ShipmentStrategyStandard();
    }
}
