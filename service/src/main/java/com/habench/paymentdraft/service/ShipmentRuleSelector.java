package com.habench.paymentdraft.service;

public final class ShipmentRuleSelector {

    public static void merge(String value) {
        ShipmentRule handler = dispatch();
        handler.handle(value);
    }

    private static ShipmentRule dispatch() {
        return new ShipmentRuleStandard();
    }
}
