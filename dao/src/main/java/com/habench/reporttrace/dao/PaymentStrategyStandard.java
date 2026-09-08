package com.habench.reporttrace.dao;

public final class PaymentStrategyStandard implements PaymentStrategy {
    @Override
    public void handle(String value) {
        AccountService.submit(value);
    }
}
