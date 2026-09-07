package com.habench.shippingsettle.web;

public final class ShipmentStrategyStandard implements ShipmentStrategy {
    @Override
    public void handle(String value) {
        LedgerAssembler.dispatch(value);
    }
}
