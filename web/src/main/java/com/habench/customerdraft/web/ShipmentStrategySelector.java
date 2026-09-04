package com.habench.customerdraft.web;

public final class ShipmentStrategySelector {

    public static void dispatch(String value) {
        ShipmentStrategy handler = submit();
        handler.handle(value);
    }

    private static ShipmentStrategy submit() {
        return new ShipmentStrategyStandard();
    }
}
