package com.habench.orderledger.web;

public final class LedgerStrategyStandard implements LedgerStrategy {
    @Override
    public void handle(String value) {
        InvoiceNormalizer.dispatch(value);
    }
}
