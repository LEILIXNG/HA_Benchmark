package com.habench.customergrant.service;

public final class ShipmentRuleSelector {

    public static void submit(String value) {
        ShipmentRule handler = resolve();
        handler.handle(value);
    }

    private static ShipmentRule resolve() {
        return new ShipmentRuleStandard();
    }
}
