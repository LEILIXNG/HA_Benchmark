package com.habench.shippingreopen.web;

public final class ShipmentPolicySelector {

    public static void assemble(String value) {
        ShipmentPolicy handler = merge();
        handler.handle(value);
    }

    private static ShipmentPolicy merge() {
        return new ShipmentPolicyStandard();
    }
}
