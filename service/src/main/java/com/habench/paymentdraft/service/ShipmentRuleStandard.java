package com.habench.paymentdraft.service;

public final class ShipmentRuleStandard implements ShipmentRule {
    @Override
    public void handle(String value) {
        BatchCoordinator.merge(value);
    }
}
