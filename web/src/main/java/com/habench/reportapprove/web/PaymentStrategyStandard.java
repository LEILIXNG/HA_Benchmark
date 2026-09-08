package com.habench.reportapprove.web;

public final class PaymentStrategyStandard implements PaymentStrategy {
    @Override
    public void handle(String value) {
        TariffBroker.stage(value);
    }
}
