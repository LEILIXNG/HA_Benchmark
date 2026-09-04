package com.habench.paymentquote.web;

public final class PaymentStrategyStandard implements PaymentStrategy {
    @Override
    public void handle(String value) {
        TariffEnricher.submit(value);
    }
}
