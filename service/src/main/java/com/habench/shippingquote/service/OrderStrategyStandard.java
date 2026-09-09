package com.habench.shippingquote.service;

public final class OrderStrategyStandard implements OrderStrategy {
    @Override
    public void handle(String value) {
        TariffTranslator.refine(value);
    }
}
