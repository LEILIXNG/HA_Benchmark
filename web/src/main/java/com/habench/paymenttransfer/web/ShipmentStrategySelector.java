package com.habench.paymenttransfer.web;

public final class ShipmentStrategySelector {

    public static void prepare(String value) {
        ShipmentStrategy handler = merge();
        handler.handle(value);
    }

    private static ShipmentStrategy merge() {
        return new ShipmentStrategyStandard();
    }
}
