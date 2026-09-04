package com.habench.pricingsplit.service;

public final class PaymentStrategyStandard implements PaymentStrategy {
    @Override
    public void handle(String value) {
        TariffRegistry.publish(value);
    }
}
