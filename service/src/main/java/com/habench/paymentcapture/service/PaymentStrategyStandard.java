package com.habench.paymentcapture.service;

public final class PaymentStrategyStandard implements PaymentStrategy {
    @Override
    public void handle(String value) {
        BundleRegistry.normalize(value);
    }
}
