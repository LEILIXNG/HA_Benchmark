package com.habench.fulfilintake.web;

public final class ShipmentStrategySelector {

    public static void assemble(String value) {
        ShipmentStrategy handler = dispatch();
        handler.handle(value);
    }

    private static ShipmentStrategy dispatch() {
        return new ShipmentStrategyStandard();
    }
}
