package com.habench.vendorrelease.web;

public final class ShipmentStrategyLegacy implements ShipmentStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
