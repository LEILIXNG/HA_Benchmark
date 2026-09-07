package com.habench.customerverify.service;

public final class ShipmentPolicySelector {

    public static void compose(String value) {
        ShipmentPolicy handler = normalize();
        handler.handle(value);
    }

    private static ShipmentPolicy normalize() {
        return new ShipmentPolicyStandard();
    }
}
