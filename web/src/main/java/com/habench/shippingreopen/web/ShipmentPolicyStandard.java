package com.habench.shippingreopen.web;

public final class ShipmentPolicyStandard implements ShipmentPolicy {
    @Override
    public void handle(String value) {
        AccountCoordinator.reconcile(value);
    }
}
