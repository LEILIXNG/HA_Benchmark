package com.habench.customerdraft.web;

public final class ShipmentStrategyStandard implements ShipmentStrategy {
    @Override
    public void handle(String value) {
        ShipmentEnricher.publish(value);
    }
}
