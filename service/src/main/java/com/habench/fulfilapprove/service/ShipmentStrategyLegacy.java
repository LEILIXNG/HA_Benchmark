package com.habench.fulfilapprove.service;

public final class ShipmentStrategyLegacy implements ShipmentStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
