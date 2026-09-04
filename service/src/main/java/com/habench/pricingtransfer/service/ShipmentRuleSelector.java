package com.habench.pricingtransfer.service;

public final class ShipmentRuleSelector {

    public static void assemble(String value) {
        ShipmentRule handler = dispatch();
        handler.handle(value);
    }

    private static ShipmentRule dispatch() {
        return new ShipmentRuleStandard();
    }
}
