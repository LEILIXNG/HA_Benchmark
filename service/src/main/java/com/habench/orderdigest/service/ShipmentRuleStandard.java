package com.habench.orderdigest.service;

public final class ShipmentRuleStandard implements ShipmentRule {
    @Override
    public void handle(String value) {
        VoucherBroker.normalize(value);
    }
}
