package com.habench.pricingtransfer.service;

public final class ShipmentRuleStandard implements ShipmentRule {
    @Override
    public void handle(String value) {
        AccountCoordinator.publish(value);
    }
}
