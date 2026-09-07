package com.habench.fulfilapprove.service;

public final class ShipmentStrategyStandard implements ShipmentStrategy {
    @Override
    public void handle(String value) {
        InvoiceResolver.stage(value);
    }
}
