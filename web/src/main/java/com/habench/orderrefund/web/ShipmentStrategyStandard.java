package com.habench.orderrefund.web;

public final class ShipmentStrategyStandard implements ShipmentStrategy {
    @Override
    public void handle(String value) {
        LedgerService.submit(value);
    }
}
