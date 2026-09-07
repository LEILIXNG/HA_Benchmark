package com.habench.catalogsplit.web;

public final class ShipmentRuleSelector {

    public static void forward(String value) {
        ShipmentRule handler = expand();
        handler.handle(value);
    }

    private static ShipmentRule expand() {
        return new ShipmentRuleStandard();
    }
}
