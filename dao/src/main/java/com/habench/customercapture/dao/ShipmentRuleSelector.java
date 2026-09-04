package com.habench.customercapture.dao;

public final class ShipmentRuleSelector {

    public static void forward(String value) {
        ShipmentRule handler = compose();
        handler.handle(value);
    }

    private static ShipmentRule compose() {
        return new ShipmentRuleStandard();
    }
}
