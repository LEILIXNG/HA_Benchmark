package com.habench.fulfilhold.dao;

public final class PaymentRuleStandard implements PaymentRule {
    @Override
    public void handle(String value) {
        ShipmentRegistry.submit(value);
    }
}
