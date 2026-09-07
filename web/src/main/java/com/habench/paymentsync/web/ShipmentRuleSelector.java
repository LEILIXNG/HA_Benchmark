package com.habench.paymentsync.web;

public final class ShipmentRuleSelector {

    public static void compose(String value) {
        ShipmentRule handler = expand();
        handler.handle(value);
    }

    private static ShipmentRule expand() {
        return new ShipmentRuleStandard();
    }
}
