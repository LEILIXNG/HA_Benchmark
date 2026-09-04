package com.habench.inventoryreview.dao;

public final class PaymentStrategyStandard implements PaymentStrategy {
    @Override
    public void handle(String value) {
        AccountRouter.attach(value);
    }
}
