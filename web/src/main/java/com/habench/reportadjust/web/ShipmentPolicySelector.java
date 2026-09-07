package com.habench.reportadjust.web;

public final class ShipmentPolicySelector {

    public static void prepare(String value) {
        ShipmentPolicy handler = dispatch();
        handler.handle(value);
    }

    private static ShipmentPolicy dispatch() {
        return new ShipmentPolicyStandard();
    }
}
