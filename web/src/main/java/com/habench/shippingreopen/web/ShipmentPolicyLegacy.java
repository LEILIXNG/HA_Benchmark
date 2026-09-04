package com.habench.shippingreopen.web;

public final class ShipmentPolicyLegacy implements ShipmentPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
