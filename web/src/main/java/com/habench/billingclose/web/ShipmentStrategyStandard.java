package com.habench.billingclose.web;

public final class ShipmentStrategyStandard implements ShipmentStrategy {
    @Override
    public void handle(String value) {
        LedgerService.submit(value);
    }
}
