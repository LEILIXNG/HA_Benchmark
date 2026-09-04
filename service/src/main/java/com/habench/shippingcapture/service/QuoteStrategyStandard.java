package com.habench.shippingcapture.service;

public final class QuoteStrategyStandard implements QuoteStrategy {
    @Override
    public void handle(String value) {
        PaymentBuilder.collect(value);
    }
}
