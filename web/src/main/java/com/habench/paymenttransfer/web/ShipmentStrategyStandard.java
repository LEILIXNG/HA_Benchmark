package com.habench.paymenttransfer.web;

public final class ShipmentStrategyStandard implements ShipmentStrategy {
    @Override
    public void handle(String value) {
        ShipmentRegistry.dispatch(value);
    }
}
