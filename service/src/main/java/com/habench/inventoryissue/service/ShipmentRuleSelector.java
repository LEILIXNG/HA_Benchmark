package com.habench.inventoryissue.service;

public final class ShipmentRuleSelector {

    public static void collect(String value) {
        ShipmentRule handler = submit();
        handler.handle(value);
    }

    private static ShipmentRule submit() {
        return new ShipmentRuleStandard();
    }
}
