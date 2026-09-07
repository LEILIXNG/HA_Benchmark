package com.habench.shippingledger.web;

public final class ShipmentRuleStandard implements ShipmentRule {
    @Override
    public void handle(String value) {
        ShipmentRouter.normalize(value);
    }
}
