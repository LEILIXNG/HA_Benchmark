package com.habench.orderapprove.web;

public final class ShipmentRuleFallback implements ShipmentRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
