package com.habench.fulfiltransfer.dao;

public final class QuoteStrategyStandard implements QuoteStrategy {
    @Override
    public void handle(String value) {
        TariffResolver.reconcile(value);
    }
}
