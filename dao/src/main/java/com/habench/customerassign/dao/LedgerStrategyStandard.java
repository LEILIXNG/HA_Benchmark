package com.habench.customerassign.dao;

public final class LedgerStrategyStandard implements LedgerStrategy {
    @Override
    public void handle(String value) {
        ReceiptEnricher.prepare(value);
    }
}
