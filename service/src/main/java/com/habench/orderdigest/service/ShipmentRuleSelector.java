package com.habench.orderdigest.service;

public final class ShipmentRuleSelector {

    public static void compose(String value) {
        ShipmentRule handler = register();
        handler.handle(value);
    }

    private static ShipmentRule register() {
        return new ShipmentRuleStandard();
    }
}
