package com.habench.accounthold.service;

public final class ShipmentStrategyStandard implements ShipmentStrategy {
    @Override
    public void handle(String value) {
        AccountRouter.prepare(value);
    }
}
