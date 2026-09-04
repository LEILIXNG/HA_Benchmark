package com.habench.billingreconcile.service;

public final class TariffStrategyStandard implements TariffStrategy {
    @Override
    public void handle(String value) {
        SessionTranslator.forward(value);
    }
}
