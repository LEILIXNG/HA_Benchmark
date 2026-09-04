package com.habench.orderapprove.web;

public final class ShipmentRuleSelector {

    public static void stage(String value) {
        ShipmentRule handler = assemble();
        handler.handle(value);
    }

    private static ShipmentRule assemble() {
        return new ShipmentRuleStandard();
    }
}
