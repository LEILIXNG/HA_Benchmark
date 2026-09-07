package com.habench.accountassign.dao;

public final class ShipmentPolicySelector {

    public static void collect(String value) {
        ShipmentPolicy handler = register();
        handler.handle(value);
    }

    private static ShipmentPolicy register() {
        return new ShipmentPolicyStandard();
    }
}
