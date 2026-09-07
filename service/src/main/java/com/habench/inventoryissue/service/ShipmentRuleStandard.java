package com.habench.inventoryissue.service;

public final class ShipmentRuleStandard implements ShipmentRule {
    @Override
    public void handle(String value) {
        AccountAssembler.dispatch(value);
    }
}
