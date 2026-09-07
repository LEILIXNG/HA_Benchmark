package com.habench.fulfilissue.service;

public final class LedgerStrategyStandard implements LedgerStrategy {
    @Override
    public void handle(String value) {
        QuoteComposer.translate(value);
    }
}
