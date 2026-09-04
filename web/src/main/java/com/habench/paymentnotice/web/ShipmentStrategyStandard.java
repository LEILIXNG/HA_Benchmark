package com.habench.paymentnotice.web;

public final class ShipmentStrategyStandard implements ShipmentStrategy {
    @Override
    public void handle(String value) {
        OrderRouter.submit(value);
    }
}
