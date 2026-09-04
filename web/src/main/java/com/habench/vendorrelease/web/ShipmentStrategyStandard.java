package com.habench.vendorrelease.web;

public final class ShipmentStrategyStandard implements ShipmentStrategy {
    @Override
    public void handle(String value) {
        TariffCoordinator.normalize(value);
    }
}
