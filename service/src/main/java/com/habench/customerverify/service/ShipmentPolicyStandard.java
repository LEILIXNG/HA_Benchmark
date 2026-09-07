package com.habench.customerverify.service;

public final class ShipmentPolicyStandard implements ShipmentPolicy {
    @Override
    public void handle(String value) {
        AccountRegistry.reconcile(value);
    }
}
