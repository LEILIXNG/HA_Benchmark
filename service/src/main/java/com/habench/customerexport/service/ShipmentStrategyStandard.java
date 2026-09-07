package com.habench.customerexport.service;

public final class ShipmentStrategyStandard implements ShipmentStrategy {
    @Override
    public void handle(String value) {
        PaymentRouter.submit(value);
    }
}
