package com.habench.reportreconcile.service;

public final class LedgerStrategyStandard implements LedgerStrategy {
    @Override
    public void handle(String value) {
        QuoteComposer.translate(value);
    }
}
