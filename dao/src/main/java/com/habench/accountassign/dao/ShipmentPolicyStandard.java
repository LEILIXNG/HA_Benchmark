package com.habench.accountassign.dao;

public final class ShipmentPolicyStandard implements ShipmentPolicy {
    @Override
    public void handle(String value) {
        SessionCoordinator.submit(value);
    }
}
