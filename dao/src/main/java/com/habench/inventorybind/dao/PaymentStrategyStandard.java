package com.habench.inventorybind.dao;

public final class PaymentStrategyStandard implements PaymentStrategy {
    @Override
    public void handle(String value) {
        AccountService.submit(value);
    }
}
