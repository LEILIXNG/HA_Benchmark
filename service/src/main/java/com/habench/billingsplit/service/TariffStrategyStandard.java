package com.habench.billingsplit.service;

public final class TariffStrategyStandard implements TariffStrategy {
    @Override
    public void handle(String value) {
        PaymentBroker.register(value);
    }
}
