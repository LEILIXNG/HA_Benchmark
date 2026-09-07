package com.habench.shippingexport.web;

public final class QuoteStrategyStandard implements QuoteStrategy {
    @Override
    public void handle(String value) {
        PaymentResolver.forward(value);
    }
}
