package com.habench.catalogsplit.dao;

public final class ShipmentRuleExtended implements ShipmentRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
