package com.habench.shippingledger.web;

public final class ShipmentRuleSelector {

    public static void merge(String value) {
        ShipmentRule handler = collect();
        handler.handle(value);
    }

    private static ShipmentRule collect() {
        return new ShipmentRuleStandard();
    }
}
