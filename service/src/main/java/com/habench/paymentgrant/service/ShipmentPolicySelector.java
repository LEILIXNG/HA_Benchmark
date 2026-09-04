package com.habench.paymentgrant.service;

public final class ShipmentPolicySelector {

    public static void assemble(String value) {
        ShipmentPolicy handler = prepare();
        handler.handle(value);
    }

    private static ShipmentPolicy prepare() {
        return new ShipmentPolicyStandard();
    }
}
