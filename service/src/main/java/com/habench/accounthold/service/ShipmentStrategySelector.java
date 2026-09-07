package com.habench.accounthold.service;

public final class ShipmentStrategySelector {

    public static void attach(String value) {
        ShipmentStrategy handler = publish();
        handler.handle(value);
    }

    private static ShipmentStrategy publish() {
        return new ShipmentStrategyStandard();
    }
}
