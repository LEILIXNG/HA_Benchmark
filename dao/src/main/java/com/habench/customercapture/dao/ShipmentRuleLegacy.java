package com.habench.customercapture.dao;

public final class ShipmentRuleLegacy implements ShipmentRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
