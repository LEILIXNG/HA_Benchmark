package com.habench.reportadjust.web;

public final class ShipmentPolicyExtended implements ShipmentPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
