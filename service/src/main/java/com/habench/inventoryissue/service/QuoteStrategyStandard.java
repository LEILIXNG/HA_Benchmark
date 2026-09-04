package com.habench.inventoryissue.service;

public final class QuoteStrategyStandard implements QuoteStrategy {
    @Override
    public void handle(String value) {
        AccountAssembler.compose(value);
    }
}
