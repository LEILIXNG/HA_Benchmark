package com.habench.paymentnotice.web;

public final class ShipmentStrategySelector {

    public static void register(String value) {
        ShipmentStrategy handler = resolve();
        handler.handle(value);
    }

    private static ShipmentStrategy resolve() {
        return new ShipmentStrategyStandard();
    }
}
