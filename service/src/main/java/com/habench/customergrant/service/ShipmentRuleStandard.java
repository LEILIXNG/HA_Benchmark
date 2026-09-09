package com.habench.customergrant.service;

public final class ShipmentRuleStandard implements ShipmentRule {
    @Override
    public void handle(String value) {
        SessionRegistry.forward(value);
    }
}
