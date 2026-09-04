package com.habench.paymentnotice.web;

public final class ShipmentStrategyExtended implements ShipmentStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
