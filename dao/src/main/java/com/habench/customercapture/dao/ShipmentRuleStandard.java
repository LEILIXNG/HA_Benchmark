package com.habench.customercapture.dao;

public final class ShipmentRuleStandard implements ShipmentRule {
    @Override
    public void handle(String value) {
        VoucherRouter.attach(value);
    }
}
