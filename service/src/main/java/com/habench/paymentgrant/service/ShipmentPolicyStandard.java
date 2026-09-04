package com.habench.paymentgrant.service;

public final class ShipmentPolicyStandard implements ShipmentPolicy {
    @Override
    public void handle(String value) {
        SessionBroker.register(value);
    }
}
