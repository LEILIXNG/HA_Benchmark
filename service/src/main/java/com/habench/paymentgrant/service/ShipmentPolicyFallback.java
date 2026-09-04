package com.habench.paymentgrant.service;

public final class ShipmentPolicyFallback implements ShipmentPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
